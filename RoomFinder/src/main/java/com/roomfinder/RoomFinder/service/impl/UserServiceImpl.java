package com.roomfinder.RoomFinder.service.impl;

import com.roomfinder.RoomFinder.model.User;
import com.roomfinder.RoomFinder.repository.UserRepository;
import com.roomfinder.RoomFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired //link service class with repo
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll(); //
    }

    @Override
    public User findById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
         userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found!"));
         return userRepository.save(user);
        //return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        userRepository.deleteById(id);
        return "User Deleted Succesfully";
    }

}
