package com.beans.user;

public class Customer_bean {
	protected String user_id;
	protected String name;
	protected String password;
	protected int lv;
	
	
	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	/**
	 * 
	 */
	public Customer_bean() {
		
	}
	
	/**
	 * @param user_id
	 * @param name
	 * @param password
	 */



	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id
	 * @param name
	 * @param password
	 * @param lv
	 */
	public Customer_bean(String user_id, String name, String password, int lv) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.lv = lv;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
