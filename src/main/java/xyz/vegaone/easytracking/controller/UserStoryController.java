package xyz.vegaone.easytracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.easytracking.dto.UserStory;
import xyz.vegaone.easytracking.service.UserStoryService;

@Controller
@RequestMapping("/userStory")
public class UserStoryController {

    private final UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserStory createUserStory(UserStory userStory) {

        return userStoryService.createUserStory(userStory);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserStory getUserStory(@PathVariable("id") Long id) {

        return userStoryService.getUserStory(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserStory updateUserStory(UserStory userStory) {

        return userStoryService.updateUserStory(userStory);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUserStory(UserStory userStory) {

        userStoryService.deleteUserStory(userStory);
    }
}
