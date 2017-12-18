package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.TaskEntity;
import xyz.vegaone.easytracking.dto.Task;
import xyz.vegaone.easytracking.repo.TaskRepo;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    private final Mapper mapper;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo, Mapper mapper) {
        this.taskRepo = taskRepo;
        this.mapper = mapper;
    }

    @Override
    public Task getTask(Long id) {
        Optional findResult = taskRepo.findById(id);

        TaskEntity taskEntity;
        if (findResult.isPresent()) {
            taskEntity = (TaskEntity) findResult.get();
            return mapper.map(taskEntity, Task.class);
        } else {
            return null;
        }
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = mapper.map(task, TaskEntity.class);

        TaskEntity savedTaskEntity = taskRepo.save(taskEntity);

        return mapper.map(savedTaskEntity, Task.class);
    }

    @Override
    public Task updateTask(Task task) {
        TaskEntity taskEntity = mapper.map(task, TaskEntity.class);

        TaskEntity savedTaskEntity = taskRepo.save(taskEntity);

        return mapper.map(savedTaskEntity, Task.class);
    }

    @Override
    public void deleteTask(Task task) {
        TaskEntity taskEntity = mapper.map(task, TaskEntity.class);

        taskRepo.delete(taskEntity);
    }
}
