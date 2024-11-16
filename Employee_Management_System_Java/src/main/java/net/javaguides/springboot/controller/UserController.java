package net.javaguides.springboot.controller;


import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
//@CrossOrigin("*")
public class UserController {

    private UserService userService;

    // build create restapi
    //http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser= userService.creatUser(user);
       return  new ResponseEntity<>(savedUser , HttpStatus.CREATED);

    }
    //build get user by id restapi
    //http://localhost:8080/api/users/id
    @GetMapping("{id}")
    public ResponseEntity <User> getUserById(@PathVariable("id") Long userId){
         User user= userService .getUserByid(userId);
         return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // build getall users restapi
    //http://localhost:8080/api/users/users
    @GetMapping()
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Build update user Restapi
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updateUser= userService.updateUser(user);
        return  new ResponseEntity<>(updateUser,HttpStatus.OK);

    }
    // Build delete user rest API
   // http://localhost:8080/api/users/21
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfuly Deleted!",HttpStatus.OK);
    }
}
