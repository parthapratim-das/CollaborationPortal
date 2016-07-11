package collaborationportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import collaborationportal.dao.BlogDAO;
import collaborationportal.models.*;;



@Service
public class BlogService {

	@Autowired
	private BlogDAO blogDAO;

	public void setBlogDAO(BlogDAO u) {
		this.blogDAO = u;
	}

	@Transactional
	public void addBlog(Blog b) {
		blogDAO.addBlog(b);
	}

	
	@Transactional
	public List<Blog> listBlogs() {
		return blogDAO.listBlogs();
	}
	
	@Transactional
	public void removeBlog(int id)
	{
		this.blogDAO.deleteBlog(id);
	}

}
