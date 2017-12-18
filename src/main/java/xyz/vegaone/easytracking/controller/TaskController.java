package xyz.vegaone.easytracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.easytracking.dto.Task;
import xyz.vegaone.easytracking.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task createTask(Task task) {

        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable("id") Long id) {

        return taskService.getTask(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task updateTask(Task task) {

        return taskService.updateTask(task);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(Task task) {

        taskService.deleteTask(task);
    }
}
