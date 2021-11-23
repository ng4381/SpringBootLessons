package com.example.demo.controller;

import com.example.demo.IMyBean;
import com.example.demo.exception.NoUserFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${myapp.version:0.0}")
    String version;

    @Autowired
    //@Qualifier("bean1")
    IMyBean iMyBean;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity(userService.getUsers(), userService.getUsers().size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        //return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) throws NoUserFoundException {

        logger.debug("try to delete user");

        if(userService.deleteUser(id) != 0 ){
            logger.debug("delete successful");
            return new ResponseEntity(HttpStatus.OK);
        }else {
            logger.error("user not found");
            throw new NoUserFoundException("User not found!");
        }

    }

    @GetMapping("/version")
    public String getVersion() {
        return version;
    }

    @GetMapping("/bean/message")
    public String getBeanMessage() {
        return iMyBean.getMessage();
    }


}
