package com.proyecto.Ecommerce.xyzshop.services.customer.cart;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.Ecommerce.xyzshop.dto.AddProductInCartDto;
import com.proyecto.Ecommerce.xyzshop.dto.CartItemsDto;
import com.proyecto.Ecommerce.xyzshop.dto.OrderDto;
import com.proyecto.Ecommerce.xyzshop.entity.CartItems;
import com.proyecto.Ecommerce.xyzshop.entity.Order;
import com.proyecto.Ecommerce.xyzshop.entity.Product;
import com.proyecto.Ecommerce.xyzshop.entity.User;
import com.proyecto.Ecommerce.xyzshop.enums.OrderStatus;
import com.proyecto.Ecommerce.xyzshop.repository.CartItemsRepository;
import com.proyecto.Ecommerce.xyzshop.repository.OrderRepository;
import com.proyecto.Ecommerce.xyzshop.repository.ProductRepository;
import com.proyecto.Ecommerce.xyzshop.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto){
		Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
		Optional<CartItems> optionalCartItems = cartItemsRepository.findByProductIdAndOrderIdAndUserId
				(addProductInCartDto.getProductId(), activeOrder.getId(), addProductInCartDto.getUserId());
		
		if(optionalCartItems.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}else {
			Optional<Product> optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
			Optional<User> optionalUser = userRepository.findById(addProductInCartDto.getUserId());
			
			if(optionalProduct.isPresent() && optionalUser.isPresent()) {
				CartItems cart = new CartItems();
				cart.setProduct(optionalProduct.get());
				cart.setPrice(optionalProduct.get().getPrice());
				cart.setQuantity(1L);
				cart.setUser(optionalUser.get());
				cart.setOrder(activeOrder);
				
				CartItems updatedCart = cartItemsRepository.save(cart);
				
				activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cart.getPrice());
				activeOrder.setAmount(activeOrder.getAmount() + cart.getPrice());
				activeOrder.getCartItems().add(cart);
				
				orderRepository.save(activeOrder);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(cart.getId());
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");
			}
		}
	}
	
	public OrderDto getCartByUserId(Long userId) {
		Order activeOrder = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.Pending);
		List<CartItemsDto> cartItemsDtoList = activeOrder.getCartItems().stream().map(CartItems::getCartDto).collect(Collectors.toList());
		OrderDto orderDto = new OrderDto();
		orderDto.setAmount(activeOrder.getAmount());
		orderDto.setId(activeOrder.getId());
		orderDto.setOrderStatus(activeOrder.getOrderStatus());
		orderDto.setTotalAmount(activeOrder.getTotalAmount());
		orderDto.setCartItems(cartItemsDtoList);
		
		return orderDto;
	}
	
	public OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto) {
		Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
		Optional<Product> optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
		
		Optional<CartItems> optionalCartItem = cartItemsRepository.findByProductIdAndOrderIdAndUserId(addProductInCartDto.getProductId(), activeOrder.getId(), addProductInCartDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalCartItem.isPresent()) {
			CartItems cartItem = optionalCartItem.get();
			Product product = optionalProduct.get();
			
			activeOrder.setAmount(activeOrder.getAmount() + product.getPrice());
			activeOrder.setTotalAmount(activeOrder.getTotalAmount() + product.getPrice());
			
			
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			
			
			
		}
		return null;
	}
}
