package com.proyecto.Ecommerce.xyzshop.services.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.Ecommerce.xyzshop.dto.ProductDto;
import com.proyecto.Ecommerce.xyzshop.entity.Product;
import com.proyecto.Ecommerce.xyzshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService{
	
	private final ProductRepository productRepository;
	
	public List<ProductDto> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	public List<ProductDto> searchProductByTitle(String name){
		List<Product> products = productRepository.findAllByNameContaining(name);
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}

}
