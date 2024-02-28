package com.example.lab1.servlets;

import com.example.lab1.dto.ProjectDTO;
import com.example.lab1.entities.Project;
import com.example.lab1.services.ProjectService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "projectServlet", value = "/project-servlet")
public class ProjectServlet extends HttpServlet {
    @Inject
    private ProjectService projectService;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id_project") != null) {
            try {
                projectService.delete(Long.valueOf(request.getParameter("id_project")));
                response.sendRedirect("./main-servlet");
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        ProjectDTO project = new ProjectDTO();
        project.setId(Long.valueOf(request.getParameter("id")));
        project.setProject_name(request.getParameter("project_name"));
        project.setBudget(Integer.parseInt(request.getParameter("budget")));
        project.setCommandId(Long.valueOf((request.getParameter("id_command"))));

        projectService.persist(new Project(project));
        response.sendRedirect("./main-servlet");
    }
}
