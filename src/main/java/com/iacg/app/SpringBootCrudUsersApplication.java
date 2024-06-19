package com.iacg.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.iacg.app.repositories.IUserRepository;
import com.iacg.app.repositories.entity.UserEntity;

@SpringBootApplication
public class SpringBootCrudUsersApplication implements CommandLineRunner{

	@Autowired
	private Faker faker;
	
	@Autowired
	private IUserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudUsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random random = new Random();
		List<UserEntity> users = new ArrayList<>();
		for(int i=0; i<10; i++) {
			UserEntity u = new UserEntity();
			u.setName(faker.name().name());
			u.setLastName(faker.name().lastName());
			u.setAge(random.nextInt(70));
			u.setPhoneNomber(faker.phoneNumber().cellPhone());
			u.setCreatAt(new Date());
			users.add(u);
		}
		repository.saveAll(users);
	}

}
