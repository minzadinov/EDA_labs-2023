package com.example.demo.restControllers;

import com.example.demo.models.Project;
import com.example.demo.repos.ProjectRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.example.demo.xslTransform.getModelAndView;


@RestController
@RequestMapping(
        value = "/api",
        produces = {"application/json", "application/xml"}
)
public class RestProjectController {
    private final ProjectRepo projectRepo;

    @Autowired
    public RestProjectController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @GetMapping("/project")
    public @ResponseBody Iterable<Project> getProjects() {
        return projectRepo.findAll();
    }

    @GetMapping("/project/{id}")
    public @ResponseBody Optional<Project> getProject(@PathVariable Long id) {
        return projectRepo.findById(id);
    }

    @PostMapping("/project")
    public @ResponseBody int createProject(@RequestBody Project project) {
        if (project == null) {
            return Response.SC_NOT_FOUND;
        }
        projectRepo.save(project);
        return Response.SC_OK;
    }

    @DeleteMapping("/project/{id}")
    public @ResponseBody int deleteProject(@PathVariable Long id) {
        if (projectRepo.findById(id).isEmpty()) {
            return Response.SC_NOT_FOUND;
        }

        projectRepo.deleteById(id);
        return Response.SC_OK;
    }

    @GetMapping(path = "/xsl/project")
    public ModelAndView getXSLProject() throws JsonProcessingException {
        Iterable<Project> list = projectRepo.findAll();
        return getModelAndView(list, "projectXSL");
    }
}
