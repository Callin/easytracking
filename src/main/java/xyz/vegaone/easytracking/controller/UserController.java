package xyz.vegaone.easytracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyz.vegaone.easytracking.dto.User;
import xyz.vegaone.easytracking.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(User user) {

        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@PathVariable("id") Long id) {

        return userService.getUser(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User updateUser(User user) {

        return userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
}
