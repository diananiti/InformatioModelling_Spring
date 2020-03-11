package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.User;
public interface UserRepository extends JpaRepository<User,Long>{
    @Modifying
    @Query("update User u set u.username = ?1, u.email = ?2,u.password=3 where u.id = ?4")
    void updateUserById(String username, String email,String password, Long id);
}
