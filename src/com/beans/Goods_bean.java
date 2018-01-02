package com.beans;

public class Goods_bean {
	protected String goods_name;
	protected float name;
	protected int stock;
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public float getName() {
		return name;
	}
	public void setName(float name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * @param goods_name
	 * @param name
	 * @param stock
	 */
	public Goods_bean(String goods_name, float name, int stock) {
		super();
		this.goods_name = goods_name;
		this.name = name;
		this.stock = stock;
	}
	/**
	 * 
	 */
	public Goods_bean() {
		super();
	}
	
	
}
