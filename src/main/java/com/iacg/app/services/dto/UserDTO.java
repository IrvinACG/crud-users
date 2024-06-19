package com.iacg.app.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor 
@Getter
@Setter
@ToString
public class UserDTO{

	private Long id;
	
	private String name;
	
	private String lastName;
	
	private int age;
	
	private String phoneNumber;
	
}
