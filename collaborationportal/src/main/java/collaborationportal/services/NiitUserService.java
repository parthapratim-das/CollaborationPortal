package collaborationportal.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collaborationportal.dao.NiitUserDAOImpl;
import collaborationportal.models.Niitusers;

@Service
public class NiitUserService {
	
	@Autowired
	private NiitUserDAOImpl ndi;

	public void addUser(Niitusers nu)
	{
		ndi.addUser(nu);
	}
	
	public List<Niitusers> detailsUser(int id)
	{
			return ndi.detailsUser(id);					
		
	}
	
}
