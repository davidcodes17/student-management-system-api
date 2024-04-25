package com.davidcodes.StudentManagementSystems.repositories.userRepository;

import com.davidcodes.StudentManagementSystems.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);


    Optional<User> findUserByUserId(String userId);

}
