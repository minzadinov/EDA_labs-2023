package com.example.demo.mvcControllers;

import com.example.demo.models.Project;
import com.example.demo.models.dto.ProjectDTO;
import com.example.demo.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @PostMapping("/project-create")
    public String createProject(ProjectDTO project) {
        projectRepo.save(new Project(project));
        return "redirect:/";
    }

    @PostMapping("/project-delete")
    public String deleteProject(@RequestParam("id") Long projectId) {
        projectRepo.deleteById(projectId);
        return "redirect:/";
    }
}
