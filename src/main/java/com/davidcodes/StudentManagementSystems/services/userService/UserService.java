package com.davidcodes.StudentManagementSystems.services.userService;

import com.davidcodes.StudentManagementSystems.model.LoginUser;
import com.davidcodes.StudentManagementSystems.model.User;

public interface UserService {

    public String signup(User user);

    public String login(LoginUser user);

    public String updateUser(User user,String userId);

    public String deleteUser(String userId);

}
