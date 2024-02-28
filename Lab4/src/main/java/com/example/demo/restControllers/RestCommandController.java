package com.example.demo.restControllers;

import com.example.demo.models.Command;
import com.example.demo.repos.CommandRepo;
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
public class RestCommandController {
    private final CommandRepo commandRepo;

    @Autowired
    public RestCommandController(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    @GetMapping("/command")
    public @ResponseBody Iterable<Command> getCommands() {
        return commandRepo.findAll();
    }

    @GetMapping("/command/{id}")
    public @ResponseBody Optional<Command> getCommand(@PathVariable Long id) {
        return commandRepo.findById(id);
    }

    @PostMapping("/command")
    public @ResponseBody int createCommand(@RequestBody Command command) {
        if (command == null) {
            return Response.SC_NOT_FOUND;
        }
        commandRepo.save(command);
        return Response.SC_OK;
    }

    @DeleteMapping("/command/{id}")
    public @ResponseBody int deleteCommand(@PathVariable Long id) {
        if (commandRepo.findById(id).isEmpty()) {
            return Response.SC_NOT_FOUND;
        }

        commandRepo.deleteById(id);
        return Response.SC_OK;
    }

    @GetMapping(path = "/xsl/command")
    public ModelAndView getXSLCommand() throws JsonProcessingException {
        Iterable<Command> list = commandRepo.findAll();
        return getModelAndView(list, "commandXSL");
    }
}
