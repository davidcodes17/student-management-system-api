package com.davidcodes.StudentManagementSystems.repositories.userRepository;

import com.davidcodes.StudentManagementSystems.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);


    Optional<User> findUserByUserId(String userId);

}
