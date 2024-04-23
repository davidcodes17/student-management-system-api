package com.davidcodes.StudentManagementSystems.repositories.userRepository;

import com.davidcodes.StudentManagementSystems.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
