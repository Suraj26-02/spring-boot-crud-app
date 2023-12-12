package com.demo.crud.repopsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long >{

}
