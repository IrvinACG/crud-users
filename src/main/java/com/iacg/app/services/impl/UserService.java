package com.iacg.app.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacg.app.repositories.IUserRepository;
import com.iacg.app.repositories.entity.UserEntity;
import com.iacg.app.services.IUserService;
import com.iacg.app.services.dto.UserDTO;
import com.iacg.app.services.mapper.UserMapper;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository repository;
	
	@Override
	public List<UserDTO> findAll() {
		
		return repository.findAll()
				.stream()
				.map(UserMapper::userToDto)
				.toList();
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<UserEntity> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			return null;
		}
		
		return UserMapper.userToDto(userOpt.get());
	}

	@Override
	public UserDTO save(UserDTO userDto) {
		UserEntity user = new UserEntity();
		user.setName(userDto.getName());
		user.setLastName(userDto.getLastName());
		user.setAge(userDto.getAge());
		user.setPhoneNomber(userDto.getPhoneNumber());
		user.setCreatAt(new Date());
		return UserMapper.userToDto(repository.save(user));
	}
	
	@Override
	public UserDTO update(Long id, UserDTO userDto) {
		Optional<UserEntity> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			return null;
		}
		UserEntity user = userOpt.get();
		user.setName(userDto.getName());
		user.setLastName(userDto.getLastName());
		user.setAge(userDto.getAge());
		user.setPhoneNomber(userDto.getPhoneNumber());
		return UserMapper.userToDto(repository.save(user));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
