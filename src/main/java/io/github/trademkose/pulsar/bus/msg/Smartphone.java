package io.github.trademkose.pulsar.bus.msg;

public class Smartphone extends Product{
    private String imei;
    private float price_tl;
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public float getPrice_tl() {
		return price_tl;
	}
	public void setPrice_tl(float price_tl) {
		this.price_tl = price_tl;
	}
	@Override
	public String toString() {
		return "Smartphone [imei=" + imei + ", price_tl=" + price_tl + ", getImei()=" + getImei() + ", getPrice_tl()="
				+ getPrice_tl() + ", getId()=" + getId() + ", getCategory_name()=" + getCategory_name()
				+ ", getPrice_usd()=" + getPrice_usd() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	} 
    
    
}
