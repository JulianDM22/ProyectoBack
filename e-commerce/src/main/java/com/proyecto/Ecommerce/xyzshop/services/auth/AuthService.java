package com.proyecto.Ecommerce.xyzshop.services.auth;

import com.proyecto.Ecommerce.xyzshop.dto.SignupRequest;
import com.proyecto.Ecommerce.xyzshop.dto.UserDto;

public interface AuthService {
	
	UserDto createUser(SignupRequest signupRequest);
	
	Boolean hasUserWithEmail(String email);
}
