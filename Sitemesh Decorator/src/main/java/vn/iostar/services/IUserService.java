package vn.iostar.services;

import vn.iostar.models.UserModels;

public interface IUserService {
	UserModels login(String username, String password);
	
	UserModels FindByUserName(String username);
	boolean register(String email, String password, String username, String fullname, String code);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean forgotPassWord(String username, String password);
}
