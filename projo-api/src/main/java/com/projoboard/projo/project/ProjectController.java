package com.projoboard.projo.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Method to parse a GET request
     * Returns all projects
     *
     * @return list of projects
     */
    @GetMapping("")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    /**
     * Method to parse a GET request
     * Get a project with ID specified in URI
     *
     * @param id ID of a project to get
     * @return project with the specified ID
     */
    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    /**
     * Method to parse a POST request
     * Create a new project
     *
     * @param project Project object passed through Request Body
     * @return the created project object with a new ID
     */
    @PostMapping("")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    /**
     * Method to parse a PUT request
     * Update a project with an ID specified in URI, if the entry with specified ID doesn't exist,
     * a new object with this ID will be created
     *
     * @param id      ID of a project to update
     * @param project project object with fields to update
     * @return the updated project object
     */
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    /**
     * Method to parse a DELETE request
     * Delete a project with an ID specified in URI
     *
     * @param id ID of a project to delete
     */
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
