package com.example.springvalidationexample.Controller;

import com.example.springvalidationexample.dto.UserRequest;
import com.example.springvalidationexample.entity.User;
import com.example.springvalidationexample.exception.UserNotFoundException;
import com.example.springvalidationexample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add-user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(request));
    }

    @GetMapping("/fetch-users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());
    }
    @GetMapping("/fetch-user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

}
