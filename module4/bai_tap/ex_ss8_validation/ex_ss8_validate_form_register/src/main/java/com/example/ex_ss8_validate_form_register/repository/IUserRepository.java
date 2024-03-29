package com.example.ex_ss8_validate_form_register.repository;

import com.example.ex_ss8_validate_form_register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
}
