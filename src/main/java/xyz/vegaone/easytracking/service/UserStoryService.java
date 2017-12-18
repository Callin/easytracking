package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.UserStory;

public interface UserStoryService {

    UserStory getUserStory(Long id);

    UserStory createUserStory(UserStory userStory);

    UserStory updateUserStory(UserStory userStory);

    void deleteUserStory(UserStory userStory);
}
