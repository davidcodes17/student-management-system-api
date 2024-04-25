package com.davidcodes.StudentManagementSystems.services.userService;

import com.davidcodes.StudentManagementSystems.configuration.Configuration;
import com.davidcodes.StudentManagementSystems.exceptions.ResourceNotFound;
import com.davidcodes.StudentManagementSystems.jwt.JwtUtil;
import com.davidcodes.StudentManagementSystems.model.LoginUser;
import com.davidcodes.StudentManagementSystems.model.User;
import com.davidcodes.StudentManagementSystems.repositories.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final Configuration configuration;

    @Autowired
    private JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        configuration = new Configuration();
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String signup(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        User found_user = userRepository.findUserByEmail(user.getEmail());
        boolean exsists = (found_user != null) ? true : false;
        if (exsists) {
            return "User already Exsist for email " + user.getEmail();
        }
        user.setPassword(configuration.encodePassword(user.getPassword(), passwordEncoder));
        userRepository.save(user);
        return jwtUtil.generateToken(uuid);
    }

    @Override
    public String login(LoginUser user) {
        User login = userRepository.findUserByEmail(user.getEmail());
        boolean exsists = (login != null) ? true : false;
        if (!exsists) {
            return "Wrong Email";
        }
        boolean isAuthenticated = configuration.verifyPassword(user.getPassword(), login.getPassword(), passwordEncoder);
        return (isAuthenticated) ? jwtUtil.generateToken(login.getUserId()) : "Wrong Password";
    }

    @Override
    public String updateUser(LoginUser user, String userId) {
        User foundUser = userRepository.findUserByUserId(userId).orElseThrow(() -> new ResourceNotFound("User Not Found"));
        user.setPassword(configuration.encodePassword(user.getPassword(), passwordEncoder));
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        userRepository.save(foundUser);
        return "User updated Successfully";
    }

    @Override
    public String deleteUser(String userId) {
        User foundUser = userRepository.findUserByUserId(userId).orElseThrow(() -> new ResourceNotFound("User Not Found"));
        userRepository.delete(foundUser);
        return "User Deleted Successfully";
    }
}
