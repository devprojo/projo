package com.projoboard.projo.task;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implements tasks rest controller
 */
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Returns all tasks.
     * @return List<Task> - list of all task entries
     */
    @GetMapping("/")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    /**
     * Fetches task by id
     * @param Long id
     * @return task object
     */
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTask(id).orElse(null);
    }

    /**
     * Creates a new task entry
     * @param Task task
     * @return Task - created task
     */
    @PostMapping("/")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    /**
     * Deletes task by ids
     * @param Long id
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    /**
     * Updates task
     * @param Task task
     * @param Long id
     */
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
        taskService.updateTask(task, id);
    }
}
