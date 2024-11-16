package net.javaguides.springboot.services;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User creatUser(User user);

    User getUserByid(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
