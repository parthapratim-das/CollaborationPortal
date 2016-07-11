package collaborationportal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LogInDAOImpl {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public String getUserPassword(int userid)
	{
		String pwd;
		Session session=sessionfactory.getCurrentSession();
		List hql=session.createSQLQuery("select Niitusers.password from Niitusers where Niitusers.uid="+userid).list();
		pwd=hql.get(0).toString();
		//pwd=toString();
		
		return pwd;
	}

}
