package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.config.DBConnectionSQLServer;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModels;

public final class UserDaoImpl extends DBConnectionSQLServer implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModels> findAll() {
		String sql = "SELECT * FROM ThongTinUser";
        try {
            conn = new DBConnectionSQLServer().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                List<UserModels> list = new ArrayList<>();
                list.add(new UserModels(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getString("images"),
                    rs.getInt("roleId"),
                    rs.getString("phone"),
                    rs.getDate("createDate"),
                    rs.getString("code")
                ));
                // ... xử lý danh sách user ở đây ...
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public UserModels findByID(int id) {
		String sql = "SELECT * FROM ThongTinUser WHERE id = ?";
        try {
            Connection conn = new DBConnectionSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserModels user = new UserModels();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                user.setPassword(rs.getString("password"));
                user.setRoleid(rs.getInt("roleId"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createDate"));
                user.setCode(rs.getString("code"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

	}
	@Override
	public void insert(UserModels user) {
		String sql = "INSERT INTO ThongTinUser(id, username, email, password, image, fullname, phone, roleid, createDate, code) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try {
	        conn = super.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, user.getId());
	        ps.setString(2, user.getUsername());
	        ps.setString(3, user.getEmail());
	        ps.setString(4, user.getPassword());
	        ps.setString(5, user.getImage());
	        ps.setString(6, user.getFullname());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
//????????????????????????????????????????????????????????????????????????????????????????????
	public static void main(String[] args) {
	    try 
	    {
	    	UserDaoImpl userDao = new UserDaoImpl();
	    	System.out.println(userDao.findByID(1));
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

	@Override
	public UserModels findByUsername(String username) {
		String sql = "SELECT * FROM ThongTinUser WHERE username = ?";
        try {
            Connection conn = new DBConnectionSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserModels user = new UserModels();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                user.setPassword(rs.getString("password"));
                user.setRoleid(Integer.parseInt(rs.getString("roleId")));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createDate"));
                user.setCode(rs.getString("code"));
                
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	// bai 2
	@Override
	public void insertregister(UserModels user) {
	    String sql = "INSERT INTO ThongTinUser (email, username, fullname, password, roleId, code) VALUES (?,?,?,?,?,?)";
	    try (Connection conn = new DBConnectionSQLServer().getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, user.getEmail());
	        ps.setString(2, user.getUsername());
	        ps.setString(3, user.getFullname());
	        ps.setString(4, user.getPassword());
	        //ps.setInt(5, user.getStatus());
	        ps.setInt(6, user.getRoleid());
	        ps.setString(7, user.getCode());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public boolean checkExistUsername(String username) {
	    boolean duplicate = false;
	    String sql = "SELECT * FROM ThongTinUser WHERE username = ?";

	    try (Connection conn = new DBConnectionSQLServer().getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();

	        // Kiểm tra xem có kết quả trả về hay không
	        if (rs.next()) {
	            duplicate = true; // Nếu có kết quả nghĩa là username đã tồn tại
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return duplicate;
	}

	@Override
	public boolean checkExistEmail(String email) {
	    boolean duplicate = false;
	    String sql = "Select * From ThongTinUser where email = ?";
	    try (Connection conn = new DBConnectionSQLServer().getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            duplicate = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return duplicate;
	}

	public void update(String username, String password) {
			String sql = "UPDATE users SET password=? WHERE name=?";
			try {
				new DBConnectionSQLServer();
				Connection conn = new DBConnectionSQLServer().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, password);
				ps.setString(2, username);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}

	
}
