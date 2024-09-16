package vn.iostar.service;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.UserDaoImpl;
import vn.iostar.model.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    private User findByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public boolean register(int id, String username, String password, String fullname) {
        if (userDao.checkExistUsername(username)) {
            return false; // Username already exists
        }
        if (userDao.checkExistId(id)) {
            return false; // ID already exists
        }
        User newUser = new User(id, username, password, fullname);
        userDao.insert(newUser);
        return true;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistId(int id) {
        return userDao.checkExistId(id);
    }

    @Override
    public boolean forgotPassword(String username, String newPassword) {
        if (userDao.checkExistUsername(username)) {
            userDao.updatePassword(username, newPassword);
            return true;
        }
        return false;
    }

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean forgotPassWord(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
