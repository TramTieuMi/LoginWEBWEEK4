package vn.iostar.services.impl;

import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.models.UserModels;
import vn.iostar.services.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserModels login(String username, String password) {
		UserModels user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModels FindByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}
	//bai 2
	@Override
	public boolean register(String email, String password, String username, String fullname, String code) {
	    if (userDao.checkExistEmail(email)) {
	        return false;
	    }
	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }
	    userDao.insertregister(new UserModels(email, username, fullname, password, 3, code));
	    return true;
	}
	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}
	@Override
	public boolean forgotPassWord(String username, String password) {
		if(userDao.checkExistUsername(username))
		{
			userDao.update(username, password);
			return true;
		}
		return false;
	}
}
