package com.iacg.app.services;

import java.util.List;

import com.iacg.app.services.dto.UserDTO;

public interface IUserService {

	List<UserDTO> findAll();
	
	UserDTO findById(Long id);
	
	UserDTO save(UserDTO userDto);
	
	UserDTO update(Long id, UserDTO userDto);
	
	void delete(Long id);
	
}
