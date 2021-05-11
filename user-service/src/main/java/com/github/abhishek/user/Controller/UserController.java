package com.github.abhishek.user.Controller;
import com.github.abhishek.user.Entity.User;
import com.github.abhishek.user.Service.UserService;
import com.github.abhishek.user.valueObject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    //Create the object of User Service
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getDepartmentWithUser(@PathVariable("id") Long userId){
        log.info("Inside getDepartmentWithUser method of UserController");
        return userService.getDepartmentWithUser(userId);
    }
}
