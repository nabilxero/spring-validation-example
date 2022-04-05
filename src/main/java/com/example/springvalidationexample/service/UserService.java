package com.example.springvalidationexample.service;

import com.example.springvalidationexample.dto.UserRequest;
import com.example.springvalidationexample.entity.User;
import com.example.springvalidationexample.exception.UserNotFoundException;
import com.example.springvalidationexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User saveUser(UserRequest userRequest) {
        User user = User.userBuild(1, userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            return user.get();
        }else throw new UserNotFoundException("User not found with the ID "+id);
    }

}
