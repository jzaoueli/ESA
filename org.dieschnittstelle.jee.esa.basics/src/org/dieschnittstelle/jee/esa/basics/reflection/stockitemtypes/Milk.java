package org.dieschnittstelle.jee.esa.basics.reflection.stockitemtypes;

import org.dieschnittstelle.jee.esa.basics.IStockItem;
//import org.dieschnittstelle.jee.esa.basics.reflection.XmlName;

public class Milk implements IStockItem {

	private int units;
	
//	****
//	@XmlName("expirydate")
//	private int expiry;
//	****
	
	private String brandname;
	
	private int price;
	
	@Override
	public int getUnits() {
		return this.units;
	}

	@Override
	public void initialise(int units,String brandname) {
		this.units = units;
		this.brandname = brandname;
	}

	@Override
	public void purchase(int unitsToPurchase) {
		if (unitsToPurchase > this.units) {
			throw new RuntimeException(
					"You cannot purchase more than what is available. Got: "
							+ unitsToPurchase
							+ " units to consume, but have available only: "
							+ this.units);
		}
		this.units -= unitsToPurchase;
	}

	@Override
	public String toString() {
		return String.format("{Milk %s %d %d}", this.brandname, this.units, this.price);
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
