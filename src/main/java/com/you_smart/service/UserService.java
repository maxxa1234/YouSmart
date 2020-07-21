package com.you_smart.service;

import com.you_smart.enteties.User;
import com.you_smart.exception.UserServiceException;
import com.you_smart.repositories.PersonRepository;
import com.you_smart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addNewUser(User user) throws UserServiceException{
        if(isUserExists(user)){
           throw new UserServiceException("User with email "+user.getEmail()+ " is exists!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    public boolean isUserExists(User user){
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());

        return userFromDB.isPresent();
    }

    public User currentUser(String email){
       return userRepository.findByEmail(email).get();
    }

}
