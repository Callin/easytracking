package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Task;

public interface TaskService {

    Task getTask(Long id);

    Task createTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Task task);
}
