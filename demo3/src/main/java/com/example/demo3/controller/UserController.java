package com.example.demo3.controller;

import com.example.demo3.dto.UserDTO;
import com.example.demo3.entity.User;
import com.example.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserId/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
        return userService.getUserByUserID(userID);
    }

    @GetMapping("/getUserByUserIdAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIDAndAddress(@PathVariable String userID,@PathVariable String address){
        System.out.println("User ID:"+ userID+"User address:" +address);
        return userService.getUserByUserIDAndAddress(userID,address);
    }
}