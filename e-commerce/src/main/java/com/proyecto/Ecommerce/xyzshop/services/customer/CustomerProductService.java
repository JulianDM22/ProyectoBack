package com.proyecto.Ecommerce.xyzshop.services.customer;

import java.util.List;

import com.proyecto.Ecommerce.xyzshop.dto.ProductDto;

public interface CustomerProductService {

	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();
}
