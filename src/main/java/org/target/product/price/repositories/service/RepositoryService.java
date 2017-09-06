package org.target.product.price.repositories.service;

import org.target.product.price.domain.ProductPrice;

public interface RepositoryService {

	/**
	 * Returns all price information of all products in database.
	 * @return
	 */
	public Iterable<ProductPrice> getAllProductsPrice();
	/**
	 * Gets {@link ProductPrice} by given productId
	 * @param productId
	 * @return {@link ProductPrice} or NULL if not exists
	 */
	public ProductPrice getProductPriceById(String productId);
	
	/**
	 * Creates new {@link ProductPrice} entity.
	 * @param productPrice
	 * @return TRUE if create is success. FALSE if the given productId already exists.
	 */
	public boolean insertProductPrice(ProductPrice productPrice);
	
	/**
	 * If given productId exists it is updated with new details.
	 * @param productPrice
	 * @return Returns updated {@link ProductPrice} or NULL if cannot be updated.
	 */
	public ProductPrice update(ProductPrice productPrice);
	
	/**
	 * Deletes given productId
	 * @param productId
	 */
	public void deleteProductPrice(String productId);
	
}
