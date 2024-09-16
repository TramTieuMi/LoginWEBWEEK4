package vn.iostar.service;

import vn.iostar.model.User;

public interface UserService {
	User login(String name, String password);

	void insert(User user);
	
	boolean register(int id, String username, String password, String fullname);

	boolean checkExistUsername(String username);
	
	boolean checkExistId(int id);

	boolean forgotPassWord(String username, String password);

	boolean forgotPassword(String username, String newPassword);

}
