package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;


public class UserModels implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String image;
	private int roleid;
	private String phone;
	private Date createDate;
	private String code;
	public UserModels() {
		super();
	}
	// cai nay cho bai cũ để test kết nối
	public UserModels(int id, String username, String email, String password, String fullname, String image, int roleid,
			String phone, Date createdDate, String code) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.image = image;
		this.roleid = roleid;
		this.phone = phone;
		this.createDate = createdDate;
		this.code = code;
	}
	//constructor cho ...
	public UserModels(String username, String email, String password, String fullname, int roleid, String code) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleid = roleid;
		this.code = code;
	}
	
	//cons cho ...
	public UserModels(String username, String email, String fullname, String code) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.code = code;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createDate = createdDate;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UserModels [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", image=" + image + ", roleid=" + roleid + ", phone=" + phone
				+ ", createDate=" + createDate + ", code=" + code + "]";
	}
	
	
	
}
