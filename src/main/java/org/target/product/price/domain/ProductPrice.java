package org.target.product.price.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product-price")
public class ProductPrice {
	public static final String COLLECTION_NAME = "product-price";
    
	@Id
    private String id;
        
    private Double price;
    
    private String currency;

    public ProductPrice() {
    }

	public ProductPrice(String product_id, Double price, String currency) {
		super();
		this.id = product_id;
		this.price = price;
		this.currency = currency;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
