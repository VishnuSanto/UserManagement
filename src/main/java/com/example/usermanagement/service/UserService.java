package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.UserTbl;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<String> login(UserDto userDto) {
        try {
            if (userRepository.existsByUserNameAndPassword(userDto.getUserName(),userDto.getPassword()))
                return new ResponseEntity<>("Login Successfull",HttpStatus.OK);
            return new ResponseEntity<>("UserName or Password Incorrect",HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Login Failed",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<UserDto>> listAll() {
        try{
            List<UserDto> list = userRepository.findAll().stream().map(userTbl -> new UserDto(userTbl)).collect(Collectors.toList());
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(String userName) {
        try {
            userRepository.deleteByUserName(userName);
            return new ResponseEntity<>("Deletion Successfull",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Deletion Failed",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UserDto> register(UserDto userDto) {
        try {
            if (!userRepository.existsByUserName(userDto.getUserName())){
                UserTbl userTbl = new UserTbl(userDto);
                userTbl = userRepository.save(userTbl);
                userDto.setId(userTbl.getId());
                return new ResponseEntity<>(userDto,HttpStatus.OK);
            }
            return new ResponseEntity<>(new UserDto(),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new UserDto(), HttpStatus.BAD_REQUEST);
        }
    }
}
