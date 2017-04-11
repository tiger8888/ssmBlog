package com.blog.model;

public class User extends UserKey {
	/**
	 * 密码
	 */
	 private String password;
	    /**
	     * 昵称， 自动生成，后面可修改
	     */
	 private String nickname;
	    /**
	     * 手机号码
	     */
	 private String phone;
	    /**
	     * 邮箱
	     */
	 private String email;

	 /**
	  * toString、getter setter and 构造方法
	  * 
	  * @return
	  */
	 
	 
    public String getPassword() {
        return password;
    }
    
    public User() {
		super();
	}
    public User(String password, String nickname) {
		super();
		
		this.password = password;
		this.nickname = nickname;
	}
	public User(String password) {
		super();
		
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + super.getUserid() + ", username=" +super.getUsername() + ", password=" + password + ", nickname=" + nickname
				+ ", phone=" + phone + ", email=" + email + "]";
	}

	public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}