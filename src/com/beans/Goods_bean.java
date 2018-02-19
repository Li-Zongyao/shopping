package com.beans;

public class Goods_bean {
	protected String goods_name;
	protected float prices;
	protected int stock;
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * @param goods_name
	 * @param prices
	 * @param stock
	 */
	public Goods_bean(String goods_name, float prices, int stock) {
		super();
		this.goods_name = goods_name;
		this.prices = prices;
		this.stock = stock;
	}
	/**
	 * 
	 */
	public Goods_bean() {
		super();
	}

}
