package com.marketplace.marketproject.models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private static UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //  Создать нового пользователя
    public static User createUser(User user) {
        return userRepository.save(user);
    }

    // Получить всех пользователей
    public List<User> getAllUsers(String username) {
        if(username != null)
            return userRepository.findByUsername(username);
        return userRepository.findAll();
    }

    // Получить пользователя по ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public static Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Обновить пользователя
    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    // Удалить всех пользователей
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    // Удалить пользователя
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}