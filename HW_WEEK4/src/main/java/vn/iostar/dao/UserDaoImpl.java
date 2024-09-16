package vn.iostar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.iostar.config.DBConnection;
import vn.iostar.model.User;

public class UserDaoImpl implements UserDao {
    
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public User findByUserName(String name) {
        String sql = "SELECT * FROM users WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("fullname"));
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error finding user by username", e);
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users (id, name, password, fullname) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassWord());
            ps.setString(4, user.getFullName());
            ps.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error inserting user", e);
        }
    }

    @Override
    public boolean checkExistUsername(String name) {
        String query = "SELECT * FROM users WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error checking if username exists", e);
        }
        return false;
    }

    @Override
    public boolean checkExistId(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error checking if ID exists", e);
        }
        return false;
    }

	@Override
	public void update(String username, String password) {
			String sql = "UPDATE users SET password=? WHERE name=?";
			try {
				new DBConnection();
				Connection c = DBConnection.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				
				ps.setString(1, password);
				ps.setString(2, username);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}	
}