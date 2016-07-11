package collaborationportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collaborationportal.dao.LogInDAOImpl;

@Service
public class LoginService {
	
	@Autowired
	private LogInDAOImpl logindaoimpl;
	
	public String getUserPassword(int userid)
	{
		return logindaoimpl.getUserPassword(userid);
	}

}
