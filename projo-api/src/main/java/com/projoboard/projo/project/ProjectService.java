package com.projoboard.projo.project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Find all Project entries
     *
     * @return list of all Project entries
     */
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    /**
     * Find a Project entry with a specified ID
     *
     * @param id id of Project to find
     * @return Project object if found, else null
     */
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    /**
     * Create a new Project entry
     *
     * @param project Project object to save in the repository
     * @return created Project object, this object will have a new ID
     */
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Update Project entry in the repository, if the entry with the specified ID doesn't exist
     * a new entry will be created
     *
     * @param id             ID of a Project to update
     * @param updatedProject Project object with different fields
     * @return updated Project object
     */
    public Project updateProject(Long id, Project updatedProject) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            updatedProject.setId(id);
            return projectRepository.save(updatedProject);
        } else {
            project.setTitle(updatedProject.getTitle());
            project.setBoards(updatedProject.getBoards());
            return projectRepository.save(project);
        }
    }

    /**
     * Delete Project entry with specified ID
     *
     * @param id ID of Project to delete
     */
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
