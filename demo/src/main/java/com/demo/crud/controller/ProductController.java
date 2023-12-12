package com.demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.entity.Product;
import com.demo.crud.service.impl.ProductServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;

	@RequestMapping(value="/add",method = RequestMethod.POST)
    private ResponseEntity<?> addProduct(HttpServletRequest request,@RequestBody Product product) {

        log.info("==== post Call arrived for Adding new Product ====");
        try {
        	productServiceImpl.addProduct(product);
        	 log.info("==== product added successfully {}=====",product);
        } catch (Exception e) {
            log.debug("error occured while adding product...{}", e.getMessage());
        }
        return new ResponseEntity<>("product added succesfully",HttpStatus.OK);
    }
	
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
    private ResponseEntity<?> updateProduct(HttpServletRequest request,@RequestBody Product product) {

        log.info("==== post Call arrived for Updating new Product ====");
        try {
        	productServiceImpl.updateProduct(product);
        	 log.info("==== product updated successfully {}=====",product);
        } catch (Exception e) {
            log.debug("error occured while updating product...{}", e.getMessage());
        }
        return new ResponseEntity<>("product updated succesfully",HttpStatus.OK);
    }
    
	
	@RequestMapping(value="/get_product",method = RequestMethod.GET)
    private ResponseEntity<Product> getProduct(HttpServletRequest request,@RequestParam("id")long id) {

        log.info("==== post Call arrived for Updating new Product ====");
        Product product=new Product();
        try {
        	 product=productServiceImpl.getProductById(id);
        	 log.info("==== product fetch successfully for id{}=====",id);
        } catch (Exception e) {
            log.debug("error occured while fetching product...{}", e.getMessage());
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
	
	@RequestMapping(value="/delete_product",method = RequestMethod.DELETE)
    private ResponseEntity<?> deleteProduct(HttpServletRequest request,@RequestParam("id")long id) {

        log.info("==== delete Call arrived for id {} ====",id);
       
        try {
        	 productServiceImpl.deleteProductById(id);
        	 log.info("==== product deleted successfully for id{}=====",id);
        } catch (Exception e) {
            log.debug("error occured while deleting product...{}", e.getMessage());
        }
        return new ResponseEntity<>("product deleted succesfully",HttpStatus.OK);
    }
}
