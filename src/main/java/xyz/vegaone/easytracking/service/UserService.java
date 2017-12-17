package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.User;

public interface UserService {
    User getUser(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(User user);
}
