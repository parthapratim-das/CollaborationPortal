package collaborationportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collaborationportal.models.Niitusers;

@Repository
@Transactional
public class NiitUserDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addUser(Niitusers nu) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(nu);
       }
	
	public List<Niitusers> detailsUser(int userid)
	{
		  Session session=sessionFactory.getCurrentSession();
		  List<Niitusers> specificUser =(List<Niitusers>)session.createSQLQuery("select * from Niitusers where Niitusers.uid="+userid).addEntity(Niitusers.class).list();
		  //System.out.println(user.getFirstname());
		  //List<Niitusers> list=new ArrayList();
		  return specificUser;
	}

	

	
	
}
