package com.iacg.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iacg.app.repositories.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>{

}
