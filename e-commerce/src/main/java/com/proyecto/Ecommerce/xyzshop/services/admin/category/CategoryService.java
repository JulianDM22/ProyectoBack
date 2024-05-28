package com.proyecto.Ecommerce.xyzshop.services.admin.category;

import java.util.List;

import com.proyecto.Ecommerce.xyzshop.dto.CategoryDto;
import com.proyecto.Ecommerce.xyzshop.entity.Category;

public interface CategoryService {

	
	Category createcategory(CategoryDto categoryDto);
	
	List<Category> getAllCategories();
}
