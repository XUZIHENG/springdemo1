package com.example.demo1.pojo;/**
 * Created by Administrator on 2018/12/11.
 */

/**
 *@author xuziheng
 *@date 2018/12/11
 *@since 1.0
 */

public class User {
	private Long id;
	private String name;
	private String email;

	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
