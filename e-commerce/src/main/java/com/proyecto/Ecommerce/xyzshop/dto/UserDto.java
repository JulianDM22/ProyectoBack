package com.proyecto.Ecommerce.xyzshop.dto;

import com.proyecto.Ecommerce.xyzshop.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
	private Long id;
	private String email;
	private String name;
	private UserRole userRole;
}
