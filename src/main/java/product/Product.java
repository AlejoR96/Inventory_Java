package product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Modelo de datos para la base de datos 
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double price;
	private double cost;
	private Integer brand;
	
	public Product () {
		
	}
	
	public Product (Integer id,String name, double price,double cost, Integer brand) {
		this.id= id;		
		this.name = name;		
		this.price= price;		
		this.cost= cost;		
		this.brand= brand;		
	}
	
	public Product (String name, double price,double cost, Integer brand) {		
		this.name = name;		
		this.price= price;		
		this.cost= cost;		
		this.brand= brand;		
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
	
	public Integer getBrand() {
		return brand;
	}
	
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Product{" + "id=" + id +
			   ", name=" + name + '\'' +
			   ", price=" + price +
			   ", cost="  + cost  +
			   ", brand=" + brand +
			   '}';
	}
	
	
	
	
	
	
	
	

}
