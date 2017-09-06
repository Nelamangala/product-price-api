package org.target.product.price.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.target.product.price.domain.ProductPrice;
import org.target.product.price.repositories.service.RepositoryService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/product-price")
public class ProductPriceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductPriceController.class);
    
    private RepositoryService repositoryService;


    @Autowired
    public ProductPriceController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllProductsPrice() {
    		return new ResponseEntity<Iterable<ProductPrice>>(repositoryService.getAllProductsPrice(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> add(@RequestBody @Valid ProductPrice productPrice) {
        logger.info("Updating price for product with id: " + productPrice.getId());
        ProductPrice currentProductPrice = repositoryService.update(productPrice);
        if(currentProductPrice == null) {
        		return ResponseEntity.status(HttpStatus.OK).body("Could not find product with id:" + productPrice.getId());
        }
        
        return new ResponseEntity<ProductPrice>(currentProductPrice, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody @Valid ProductPrice productPrice) {
        logger.info("Creating price for product with id: " + productPrice.getId());
        if(!repositoryService.insertProductPrice(productPrice)) {
        		return ResponseEntity.status(HttpStatus.OK).body("Cannot be created. Product already exists with id:" + productPrice.getId());
        }
        return new ResponseEntity<ProductPrice>(productPrice, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id) {
        logger.info("Getting price of product with id: " + id);
        ProductPrice newProductPrice = repositoryService.getProductPriceById(id);
        if(newProductPrice == null) {
        		return ResponseEntity.status(HttpStatus.OK).body("Could not find product with id:" + id);
        }
        return new ResponseEntity<ProductPrice>(newProductPrice, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting price for product with id: " + id);
        repositoryService.deleteProductPrice(id);
    }
}