package com.blog.model;

/**
 * 外键类，一些根据这些外键相关的表可继承此类
 * @author Administrator
 *
 */
public class UserKey {
    public UserKey() {
		super();
	}

	@Override
	public String toString() {
		return "UserKey [userid=" + userid + ", username=" + username + "]";
	}

	public UserKey(String username) {
		super();
		this.username = username;
	}

	public UserKey(Integer userid) {
		super();
		this.userid = userid;
	}

	public UserKey(Integer userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}

	private Integer userid;

    private String username;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}