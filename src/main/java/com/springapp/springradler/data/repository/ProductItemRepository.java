package com.springapp.springradler.data.repository;

import com.springapp.springradler.data.entity.ProductItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // contains exception translation.
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
