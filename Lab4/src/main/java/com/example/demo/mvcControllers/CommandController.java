package com.example.demo.mvcControllers;

import com.example.demo.models.Command;
import com.example.demo.models.dto.CommandDTO;
import com.example.demo.repos.CommandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/command")
public class CommandController {
    private final CommandRepo commandRepo;

    @Autowired
    public CommandController(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    @PostMapping("/command-create")
    public String createCommand(CommandDTO command) {
        commandRepo.save(new Command(command));
        return "redirect:/";
    }

    @PostMapping("/command-delete")
    public String deleteCommand(@RequestParam("id") Long commandId) {
        commandRepo.deleteById(commandId);
        return "redirect:/";
    }
}
