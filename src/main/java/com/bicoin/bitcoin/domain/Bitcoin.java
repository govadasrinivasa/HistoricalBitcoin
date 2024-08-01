package com.bicoin.bitcoin.domain;

import java.util.Date;

public class Bitcoin {

	private Date date;
	private Double price;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	 
}
