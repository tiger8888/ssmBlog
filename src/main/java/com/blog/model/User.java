package com.blog.model;

public class User {
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", phone=" + phone + "]";
	}

	public User() {
		super();
	}

	private String username;

    private String password;

    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}