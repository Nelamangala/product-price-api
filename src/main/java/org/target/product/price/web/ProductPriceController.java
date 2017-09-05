package org.target.product.price.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;
import org.target.product.price.domain.ProductPrice;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/product-price")
public class ProductPriceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductPriceController.class);
    private CrudRepository<ProductPrice, String> repository;

    @Autowired
    public ProductPriceController(CrudRepository<ProductPrice, String> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ProductPrice> albums() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProductPrice add(@RequestBody @Valid ProductPrice productPrice) {
        logger.info("Adding album " + productPrice.getProduct_id());
        return repository.save(productPrice);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductPrice update(@RequestBody @Valid ProductPrice productPrice) {
        logger.info("Updating price for product with id: " + productPrice.getProduct_id());
        return repository.save(productPrice);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductPrice getById(@PathVariable String id) {
        logger.info("Getting price of product with id: " + id);
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting price for product with id: " + id);
        repository.delete(id);
    }
}