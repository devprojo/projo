package com.projoboard.projo.task;

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
     *
     * @return List<Task> - list of all task entries
     */
    @GetMapping("/")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    /**
     * Fetches task by id
     *
     * @param id
     * @return task object
     */
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id).orElse(null);
    }

    /**
     * Creates a new task entry
     *
     * @param task
     * @return Task - created task
     */
    @PostMapping("/")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * Deletes task by ids
     *
     * @param id - task id
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    /**
     * Updates task
     *
     * @param task - updated tak data
     * @param id   - id of the task to update
     */
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.updateTask(id, task);
    }
}
