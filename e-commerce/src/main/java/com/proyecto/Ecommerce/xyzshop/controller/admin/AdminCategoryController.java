package com.proyecto.Ecommerce.xyzshop.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.Ecommerce.xyzshop.dto.CategoryDto;
import com.proyecto.Ecommerce.xyzshop.entity.Category;
import com.proyecto.Ecommerce.xyzshop.services.admin.category.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

	private final CategoryService categoryService;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
		Category category = categoryService.createcategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
}
