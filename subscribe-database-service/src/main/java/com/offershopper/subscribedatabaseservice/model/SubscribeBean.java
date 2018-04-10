package com.offershopper.subscribedatabaseservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SubscribeBean {

	@Id
	private Integer userId;
	private Integer vendorId;
	private String category;//default constructor
	
	public SubscribeBean() {
		super();
	}
	
	public SubscribeBean(Integer userId, Integer vendorId, String category) {
		super();
		this.userId = userId;
		this.vendorId = vendorId;
		this.category = category;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
