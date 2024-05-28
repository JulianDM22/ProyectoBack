package com.proyecto.Ecommerce.xyzshop.entity;
import com.proyecto.Ecommerce.xyzshop.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;


/*
 * La clase User es una entidad Jpa 
 * va a representar todos los datos del usuario
 * que se van a conservar en la DB
 * */

@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	private String name;
	private UserRole role;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
}
