package com.sena.inventory.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sena.inventory.brand.Brand;



//Modelo de datos para la base de datos 
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String name;
	@DecimalMin(value = "1.0")
	private double price;
	@DecimalMin(value = "1.0")
	private double cost;
//	@NotNull (message = "Debe seleccionar una marca")
	@ManyToOne //De uno a muchos 
	@JoinColumn(name = "brand")
	private Brand brand;
	@Column(columnDefinition = "boolean default true")
	private boolean state;
	
	
	public Product () {
		
	}
	
	public Product (Integer id,String name, double price,double cost, Brand brand, boolean state) {
		this.id= id;		
		this.name = name;		
		this.price= price;		
		this.cost= cost;		
		this.brand= brand;		
		this.state = state;
	}
	
	public Product (String name, double price,double cost, Brand brand,boolean state) {		
		this.name = name;		
		this.price= price;		
		this.cost= cost;		
		this.brand= brand;
		this.state = state;	
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer setId(Integer id) {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "Product{" + "id=" + id +
			   ", name=" + name + '\'' +
			   ", price=" + price +
			   ", cost="  + cost  +
			   ", brand=" + brand +
			   ", state=" + state +
			   '}';
	}
	
	
	
	
	
	
	
	

}
