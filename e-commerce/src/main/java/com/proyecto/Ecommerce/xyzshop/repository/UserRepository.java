package com.proyecto.Ecommerce.xyzshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Ecommerce.xyzshop.entity.User;
import com.proyecto.Ecommerce.xyzshop.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findFirstByEmail(String email);
	
	User findByRole(UserRole userRole);
}
  