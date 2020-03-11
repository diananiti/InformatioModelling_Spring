package io.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUserById(long id) {
        Optional<User> os = userRepository.findById(id);
        if(os.isPresent()) userRepository.deleteById(id);
        return os.get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        Optional<User> os = userRepository.findById(id);
        if(os.isPresent()) return os.get();
        else return null;
    }

    @Override
    public User updateUser(User user) {
        userRepository.updateUserById(user.getUsername(), user.getEmail(),user.getPassword(), user.getId());
        return user;
//// if you want to check rollNo first:
//		Optional<User> os = userRepository.findById(user.getRollNo());
//		if(os.isPresent())
//		{ os.get().setName(user.getName());
//		  os.get().setSurname(user.getSurname());
//		  userRepository.save(os.get());
//		  return os.get();}
//		else return null;

    }
}
