package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/addUser")
    public @ResponseBody User registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    @PostMapping(path = "/login")
    public @ResponseBody boolean logginUser(@RequestParam String email, @RequestParam String password){
        if(email.isEmpty() || password.isEmpty()){
            return false;
        }
        User user = userRepository.findByEmail(email);
        if(user==null){
            return false;
        }
        if(user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
