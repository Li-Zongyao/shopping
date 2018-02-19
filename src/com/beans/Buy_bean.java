package com.beans;

public class Buy_bean {
	String time;
	String goods_name;
	int number;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @param time
	 * @param goods_name
	 * @param number
	 */
	public Buy_bean(String time, String goods_name, int number) {
		super();
		this.time = time;
		this.goods_name = goods_name;
		this.number = number;
	}
	/**
	 * 
	 */
	public Buy_bean() {
		super();
	}
	

}
