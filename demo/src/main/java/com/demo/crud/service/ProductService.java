package com.demo.crud.service;

import java.sql.SQLException;

import com.demo.crud.entity.Product;

public interface ProductService {

	public void addProduct(Product product) throws SQLException;
	public void updateProduct(Product product) throws SQLException;
	public Product getProductById(Long id) ;
	public void deleteProductById(Long id);
}
