package vn.iostar.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private int id;
	private String name;
	private String passWord;
	private String fullName;

	public User(int id, String name, String passWord, String fullName) {
		this.id = id;
		this.name = name;
		this.passWord = passWord;
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
