package com.example.demo.controllers;


import com.example.demo.repos.CommandRepo;
import com.example.demo.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final CommandRepo commandRepo;
    private final ProjectRepo projectRepo;

    @Autowired
    public MainController(CommandRepo commandRepo, ProjectRepo projectRepo) {
        this.commandRepo = commandRepo;
        this.projectRepo = projectRepo;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        var commands = commandRepo.findAll();
        model.addAttribute("commands", commands);
        var projects = projectRepo.findAll();
        model.addAttribute("projects", projects);
        return "main";
    }
}
