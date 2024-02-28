package com.example.lab1.servlets;

import com.example.lab1.dto.CommandDTO;
import com.example.lab1.entities.Command;
import com.example.lab1.services.CommandService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "commandServlet", value = "/command-servlet")
public class CommandServlet extends HttpServlet {
    @Inject
    private CommandService commandService;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("command_id") != null) {
            try {
                commandService.delete(Long.valueOf((request.getParameter("command_id"))));
                response.sendRedirect("./main-servlet");
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        CommandDTO command = new CommandDTO();
        command.setId(Long.valueOf(request.getParameter("id")));

        String inputFieldValue = (request.getParameter("id_persons"));

        List<String> personList = Arrays.asList(inputFieldValue.split(","));
        command.setPersons(personList);
        commandService.persist(new Command(command));
        response.sendRedirect("./main-servlet");
    }
}
