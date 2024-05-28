package com.proyecto.Ecommerce.xyzshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Ecommerce.xyzshop.entity.Order;
import com.proyecto.Ecommerce.xyzshop.enums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
}
