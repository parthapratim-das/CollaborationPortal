package collaborationportal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collaborationportal.models.*;;


@Repository
@Transactional
public class BlogDAO {

	private static final Logger logger = LoggerFactory.getLogger(NiitUserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addBlog(Blog b) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(b);
		logger.info("Blog saved successfully, Blog Details=" + b);

	}

	
	@SuppressWarnings("unchecked")
	public List<Blog> listBlogs() {
		Session session = sessionFactory.getCurrentSession();

		List<Blog> blogList = session.createQuery("from Blog").list();
		for (Blog b : blogList) {
			logger.info("Blog List::" + b);
		}

		return blogList;
	}
	
	public void deleteBlog(int id)
	{
		Session session = sessionFactory.getCurrentSession();
        Blog b = (Blog) session.get(Blog.class, new Integer(id));
        if(null != b)
        {
            session.delete(b);       
        }
	}


}

