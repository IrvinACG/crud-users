package com.iacg.app.services.mapper;

import com.iacg.app.repositories.entity.UserEntity;
import com.iacg.app.services.dto.UserDTO;

public class UserMapper {

	private UserMapper() {}
	
	public static UserDTO userToDto(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if(entity == null) {
			return null;
		}
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setAge(entity.getAge());
		dto.setPhoneNumber(entity.getPhoneNomber());
		
		return dto;
	}
	
	public static UserEntity userToEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		if(dto == null) {
			return null;
		}
		
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setAge(dto.getAge());
		entity.setPhoneNomber(dto.getPhoneNumber());
		
		return entity;
	}
	
}
