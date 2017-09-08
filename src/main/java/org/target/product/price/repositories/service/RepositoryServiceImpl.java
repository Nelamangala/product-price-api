package org.target.product.price.repositories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.target.product.price.domain.ProductPrice;
import org.target.product.price.repositories.mongodb.MongoAlbumRepository;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    
    private MongoAlbumRepository repository;
    
    @Autowired
    public RepositoryServiceImpl(MongoAlbumRepository repository) {
        this.repository = repository;
    }
    
	@Override
	public ProductPrice getProductPriceById(String productId) {
		return repository.findOne(productId);
	}

	@Override
	public boolean insertProductPrice(ProductPrice productPrice) {
		if(repository.findOne(productPrice.getId()) != null) {
			return false;
		}
		repository.save(productPrice);
		return true;
	}

	@Override
	public ProductPrice update(ProductPrice productPrice) {
		if(repository.findOne(productPrice.getId()) == null) {
			return null;
		}
		return repository.save(productPrice);
	}

	@Override
	public void deleteProductPrice(String productId) {
		repository.delete(productId);
	}

	@Override
	public Iterable<ProductPrice> getAllProductsPrice() {
		return repository.findAll();
	}

}
