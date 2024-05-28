package com.proyecto.Ecommerce.xyzshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Ecommerce.xyzshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
