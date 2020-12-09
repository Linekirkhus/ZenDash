package com.zendashproject.demo.repository;

import com.zendashproject.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
