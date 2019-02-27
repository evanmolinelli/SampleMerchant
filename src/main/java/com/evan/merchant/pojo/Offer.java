package com.evan.merchant.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OFFER")
public class Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OFFER_ID")
	private int id;
	@Column(name="SERVICE")
	private String service;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private int price;
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Offer(/*int id,*/ String service, String description, int price) {
		super();
		/*this.id=id;*/
		this.service = service;
		this.description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", service=" + service + ", description=" + description + ", price=" + price + "]";
	}
}
