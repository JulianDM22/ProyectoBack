package com.proyecto.Ecommerce.xyzshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Ecommerce.xyzshop.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

	Optional<CartItems> findByProductIdAndOrderIdAndUserId (Long productId, Long orderId, Long userId);
}
