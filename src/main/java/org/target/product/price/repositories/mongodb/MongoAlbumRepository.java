package org.target.product.price.repositories.mongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.target.product.price.domain.ProductPrice;

@Repository
@Profile("mongodb")
public interface MongoAlbumRepository extends MongoRepository<ProductPrice, String> {
}