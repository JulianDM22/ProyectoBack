package com.proyecto.Ecommerce.xyzshop.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.Ecommerce.xyzshop.dto.CategoryDto;
import com.proyecto.Ecommerce.xyzshop.entity.Category;
import com.proyecto.Ecommerce.xyzshop.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	
	public Category createcategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();	
	}
}
