package io.github.trademkose.pulsar.bus.msg;

public class Product {
	private int id;
    private String category_name;
    private float price_usd;
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public float getPrice_usd() {
		return price_usd;
	}
	public void setPrice_usd(float price_usd) {
		this.price_usd = price_usd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category_name=" + category_name + ", price_usd=" + price_usd + ", name=" + name
				+ ", getId()=" + getId() + ", getCategory_name()=" + getCategory_name() + ", getPrice_usd()="
				+ getPrice_usd() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
    
    
}
