package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.UserModels;

public interface IUserDao {
	List<UserModels> findAll();
	
	// hàm tìm bằng ID;
	UserModels findByID(int id);
	
	void insert(UserModels user);
	
	UserModels findByUsername(String username);
	void insertregister(UserModels user);
	boolean checkExistEmail(String Email);
	boolean checkExistUsername(String username);
	void update(String username, String password);
}
