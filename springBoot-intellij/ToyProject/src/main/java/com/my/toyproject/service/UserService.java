package com.my.toyproject.service;

import com.my.toyproject.domain.User;
import com.my.toyproject.persistence.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertUser(User user){
        user.setRole("USER");
        userRepository.save(user);
    }

    @Transactional
    public User getUser(String username){
        Optional<User> findUser = userRepository.findByUsername(username);
        if(findUser.isPresent()) return findUser.get();
        return new User();
    }

}
