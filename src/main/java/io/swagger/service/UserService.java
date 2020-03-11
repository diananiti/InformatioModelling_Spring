package io.swagger.service;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService {
    public User addUser(User user);
    public User deleteUserById(long id);
    public List<User> findAllUsers();
    public User updateUser(User user);
    @Cacheable("users")
   public User findUserById(long id);
}
