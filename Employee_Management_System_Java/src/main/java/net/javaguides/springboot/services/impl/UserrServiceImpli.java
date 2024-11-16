package net.javaguides.springboot.services.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserrServiceImpli implements UserService {


    private UserRepository userRepository;

    @Override
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByid(Long userId) {
        Optional<User> optionalUser= userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUseting = userRepository.findById(user.getId()).get();
        existingUseting.setFirstName(user.getFirstName());
        existingUseting.setLastName(user.getLastName());
        existingUseting.setEmail(user.getEmail());

        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
