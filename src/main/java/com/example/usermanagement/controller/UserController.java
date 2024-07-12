package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        return userService.login(userDto);
    }
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> listAllUsers(){
        return userService.listAll();
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestParam String userName){
        return userService.delete(userName);
    }

    @PostMapping("register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }
}
