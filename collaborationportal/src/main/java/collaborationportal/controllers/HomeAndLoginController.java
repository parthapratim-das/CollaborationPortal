package collaborationportal.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import collaborationportal.models.Blog;
import collaborationportal.models.Message;
import collaborationportal.models.Niitusers;
import collaborationportal.models.OutputMessage;
import collaborationportal.services.BlogService;
import collaborationportal.services.LoginService;
import collaborationportal.services.NiitUserService;

@Controller
public class HomeAndLoginController {
	
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
    private BlogService blogService;

	@Autowired
	private NiitUserService nus;
	private Path path;
	
	@Autowired
    private JavaMailSender mailSender;

	@RequestMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@RequestMapping("/backtohome")
	public String gobacktoHome()
	{
		return "home";
	}
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
	{
		return "aboutus";
	}
	
	@RequestMapping("/register")
	public String registerUser(Model model)
	{
		model.addAttribute("niituser",new Niitusers());
		return "registerUser";
	}
	
	/*@ModelAttribute("niituser")
	public Niitusers create()
	{
		return new Niitusers();
	}*/
	
	@RequestMapping(value= "/newuserdetails", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("niituser") Niitusers nu,HttpServletRequest request){
	
		String filename=null;
		  byte[] bytes;
		  if(!nu.getImage().isEmpty())
	        {
			 
	            try
	            {
	            	bytes=nu.getImage().getBytes();
	            	nus.addUser(nu);
	                System.out.println("Data Inserted");
	            
	           
	        
	                
					String path=request.getSession().getServletContext().getRealPath("/resources/images/"+nu.getUid()+".jpg");
					System.out.println("Path = "+path);
					System.out.println("File name = "+nu.getImage().getOriginalFilename());
					File f=new File(path);
					BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
					bs.write(bytes);
					bs.close();
					System.out.println("Image uploaded");
	            

					
					//Sending Email to the user
					
					// takes input from e-mail form
			        String recipientAddress = nu.getEmail();
			        String fname=nu.getFirstname();
			        String subject ="Welcome!! NIIT Employees Portal " /*request.getParameter("musichub alert")*/;
			        String message = "We are happy to see you with us at NIIT Employees Portal";
			        String finalmessage="Hi "+fname+", "+" "+message+"!!! "+"All the best. - Created by Partha";
			         
			        // prints debug info
			        System.out.println("To: " + recipientAddress);
			        System.out.println("Subject: " + subject);
			        System.out.println("Message: " + finalmessage);
			         
			        // creates a simple e-mail object
			        SimpleMailMessage email = new SimpleMailMessage();
			        email.setTo(recipientAddress);
			        email.setSubject(subject);
			        email.setText(finalmessage);
			         
			        // sends the e-mail
			        mailSender.send(email);
	            }
				catch(Exception ex)
	            {
	                System.out.println(ex.getMessage());
	            }
	        }
	        
			return "redirect:/backtohome";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView userPasswordChecking(HttpServletRequest request)
	{
		
		
		int userid=Integer.parseInt(request.getParameter("employee_code"));
		String password=loginservice.getUserPassword(userid);
		String givenPassword=request.getParameter("userpassword");
		
		ModelAndView mv=new ModelAndView("userhomepage");
		
		ModelAndView loginfail=new ModelAndView("home");
		
		List<Niitusers> list=nus.detailsUser(userid);
		Niitusers nuser=new Niitusers();
		nuser=(Niitusers)list.get(0);
		
		System.out.println(password);
		
		if(password.equals(givenPassword))
		{
			
			System.out.println(nuser.getFirstname());
			
			mv.addObject("user", nuser);
			return mv;//?user="+userid;
		}
		else
		{
			ModelMap m=new ModelMap();
			m.addAttribute("error","Invalid Username or Password");
			return loginfail;
		}
		
	}
	
	@RequestMapping(value="/showUser", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("user"));
		List<Niitusers> list=nus.detailsUser(id);
		Niitusers nuser=new Niitusers();
		nuser=(Niitusers)list.get(0);
		System.out.println(nuser.getFirstname());
		return "userhomepage";
	}
	
	@RequestMapping("/backtoHomePage")
	public String comeBackToUserHomePage()
	{
		return "userhomepage";
	}
	
	
	/*
	@RequestMapping("/Blog")
	public ModelAndView newBlog(Model m) {
		m.addAttribute("blog", new Blog());
		List<Blog> blogs = blogService.listBlogs();
		String json = new Gson().toJson(blogs);
		ModelAndView model = new ModelAndView("NewBlog");
		model.addObject("blogs", json);
		return model;
	}
	
	@RequestMapping(value = "/Blog/add",method=RequestMethod.POST)
	public String addUser(Model model,@Valid @ModelAttribute("blog") Blog b, BindingResult result, Principal principal) {

		if(result.hasErrors())
			return "NewBlog";
		
		b.setUser(principal.getName());
		b.setDate(new Date());
		blogService.addBlog(b);
					
		return "redirect:/Blog";
	
	}*/
	
	
	//============================================================================//
	
	
	@RequestMapping("/Blog")
	public ModelAndView showDetailstoAdmin(Model mp)
	{
		ModelAndView mv=new ModelAndView("NewBlog");
		
		List<Blog> listtojsp=new ArrayList<Blog>();
		listtojsp=blogService.listBlogs();
		mv.addObject("listfromtable", listtojsp);
		
		return mv;
	}
	
	@RequestMapping("/addnew")
	public String invokeAddNew()
	{
		return "addnew";
	}
	
	@ModelAttribute("product")
	public Blog create()
	{
		return new Blog();
	}
	
	@RequestMapping(value= "/newproductdetails", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Blog b, BindingResult result, HttpServletRequest request){
     
		  //String filename=null;
		  //byte[] bytes;
		  //if(!p.getImage().isEmpty())
	        //{
			 
	            try
	            {
	            	//bytes=b.getImage().getBytes();
	            	blogService.addBlog(b);
	                System.out.println("Data Inserted");
	            
	           
	        
	                
					//String path=request.getSession().getServletContext().getRealPath("/resources/images/"+p.getId()+".jpg");
					//System.out.println("Path = "+path);
					//System.out.println("File name = "+p.getImage().getOriginalFilename());
					//File f=new File(path);
					//BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
					//bs.write(bytes);
					//bs.close();
					//System.out.println("Image uploaded");
	            }
				catch(Exception ex)
	            {
	                System.out.println(ex.getMessage());
	            }
	        
			
			
			
			if (result.hasErrors()) 
			{
			 
				return "addnew";
		 
			} 
			else 
			{
		 
				if(b.getBlogid() == 0){
	            this.blogService.addBlog(b);
			}
		}
		return "redirect:/Blog";
	}
	
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
		System.out.println("in remove");
        this.blogService.removeBlog(id);
        
        return "redirect:/Blog";
    }
	
	//=================================================================================//
	
	
	
	@RequestMapping("/ChatPage")
	public ModelAndView chat() {
		ModelAndView model = new ModelAndView("chat");
		return model;
	}
	
	/*@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message, Principal principal) {
	    return new OutputMessage(message, new Date(),principal.getName());
	  }*/
}
