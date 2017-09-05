package org.target.product.price.repositories.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.target.product.price.domain.ProductPrice;

@Repository
@Profile({"in-memory"})
public interface JpaAlbumRepository extends JpaRepository<ProductPrice, String> {
}
