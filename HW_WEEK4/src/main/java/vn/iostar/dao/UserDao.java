package vn.iostar.dao;

import vn.iostar.config.DBConnection;
import vn.iostar.model.User;

public interface UserDao {
	User findByUserName(String name);

	void insert(User user);

	boolean checkExistUsername(String name);

	boolean checkExistId(int id);
	
	void update(String username, String password);

	void updatePassword(String username, String newPassword);
}
