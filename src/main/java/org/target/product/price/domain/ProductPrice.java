package org.target.product.price.domain;

import javax.persistence.Id;

public class ProductPrice {
	
	@Id
    private String product_id;
    private Double price;
    private String currency;

    public ProductPrice() {
    }

	public ProductPrice(String product_id, Double price, String currency) {
		super();
		this.product_id = product_id;
		this.price = price;
		this.currency = currency;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
