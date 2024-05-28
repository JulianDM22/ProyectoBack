package com.proyecto.Ecommerce.xyzshop.services.customer.cart;

import org.springframework.http.ResponseEntity;

import com.proyecto.Ecommerce.xyzshop.dto.AddProductInCartDto;
import com.proyecto.Ecommerce.xyzshop.dto.OrderDto;

public interface CartService {

	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
	
	OrderDto getCartByUserId(Long userId);
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
}
