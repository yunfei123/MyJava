package cn.bn.pojo;

public class User {
	private String username;//用户名
	private String password;//密码
	private String email;//邮箱
	public User() {
		super();
	}
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
