package xyz.vegaone.easytracking.task;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.Task;
import xyz.vegaone.easytracking.service.TaskService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    private final static String TASK_TITLE = "toDo";
    private final static String TASK_TITLE_TO_UPDATE = "doable";

    @Test
    public void createTaskTest() {
        //given
        Task saveResult = saveTask();

        //then
        Assert.assertNotNull("There should have been one taskEntity saved in the database.", saveResult);
        Assert.assertEquals("The taskEntity title should have matched", TASK_TITLE, saveResult.getTitle());
    }

    @Test
    public void getTaskTest() {
        //given
        Task saveResult = saveTask();

        //when
        Task findResult = taskService.getTask(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one taskEntity saved in the database", findResult);
        Assert.assertEquals("The taskEntity title should have matched", TASK_TITLE, findResult.getTitle());

    }

    @Test
    public void updateTaskTest() {
        //given
        Task saveResult = saveTask();
        saveResult.setTitle(TASK_TITLE_TO_UPDATE);

        //when
        Task updatedTask = taskService.updateTask(saveResult);
        Task findResult = taskService.getTask(updatedTask.getId());

        //then
        Assert.assertNotNull("There should have been one taskEntity saved in the database", findResult);
        Assert.assertNotEquals("The taskEntity title should have been changed", TASK_TITLE, findResult.getTitle());

    }

    @Test
    public void deleteTaskTest() {
        //given
        Task saveResult = saveTask();

        //when
        taskService.deleteTask(saveResult);
        Task findResult = taskService.getTask(saveResult.getId());

        //then
        Assert.assertNull("The taskEntity should have been removed from the database", findResult);
    }

    public Task saveTask() {
        Task task = new Task();
        task.setTitle(TASK_TITLE);
        return taskService.createTask(task);
    }
}
