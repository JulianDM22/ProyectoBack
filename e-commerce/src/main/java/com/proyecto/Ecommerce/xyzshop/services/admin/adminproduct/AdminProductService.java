package com.proyecto.Ecommerce.xyzshop.services.admin.adminproduct;

import java.io.IOException;
import java.util.List;

import com.proyecto.Ecommerce.xyzshop.dto.ProductDto;

public interface AdminProductService {

	ProductDto addProduct(ProductDto productDto) throws IOException;
	
	List<ProductDto> getAllProducts();
	
	List<ProductDto> getAllProductByName(String name);
	
	boolean deleteProduct(Long id);
}
