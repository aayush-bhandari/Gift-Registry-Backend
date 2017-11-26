package wpl.spring.entity;

import java.util.List;

public class Filter {

	private List category;
	/*private List weight;
	private List price;*/
	
	private float weight;
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	private float price;
	
	public List getCategory() {
		return category;
	}
	public void setCategory(List category) {
		this.category = category;
	}
	/*public List getWeight() {
		return weight;
	}
	public void setWeight(List weight) {
		this.weight = weight;
	}
	public List getPrice() {
		return price;
	}
	public void setPrice(List price) {
		this.price = price;
	}*/
	
	
}
