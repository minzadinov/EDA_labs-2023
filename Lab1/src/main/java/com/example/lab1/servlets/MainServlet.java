package com.example.lab1.servlets;

import com.example.lab1.entities.Command;
import com.example.lab1.entities.Project;
import com.example.lab1.services.CommandService;
import com.example.lab1.services.ProjectService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {
    @Inject
    private ProjectService projectService;

    @Inject
    private CommandService commandService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>");
        out.println("Projects");
        out.println("</h1>");
        out.println(
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
                        "                <thead>\n" +
                        "                    <tr>\n" +
                        "                        <th>id</th>\n" +
                        "                        <th>project_name</th>\n" +
                        "                        <th>budget</th>\n" +
                        "                        <th>command id</th>\n" +
                        "                    </tr>\n" +
                        "                </thead>"
        );
        out.println("<tbody>");
        List<Project> projectList = projectService.findAll();
        for (int i = 0; i < projectList.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + projectList.get(i).getId());
            out.println("<td>" + projectList.get(i).getProject_name());
            out.println("<td>" + projectList.get(i).getBudget());
            out.println("<td>" + projectList.get(i).getCommand_id());
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "        <div class=\"project-input\">\n" +
                        "            Fill the table Project\n" +
                        "            <form action=\"./project-servlet\" method=\"post\">\n" +
                        "                    <input type=\"text\" name=\"id\", placeholder=\"Id\" required=true>\n" +
                        "                    <input type=\"text\" name=\"project_name\", placeholder=\"Project name\" required=true>\n" +
                        "                    <input type=\"text\" name=\"budget\", placeholder=\"Budget\" required=true>\n" +
                        "                    <input type=\"text\" name=\"id_command\", placeholder=\"id command\" required=true>\n" +
                        "                    <button type=\"submit\">Save</button>\n" +
                        "            </form>\n" +
                        "        </div>\n");

        out.println("    <div class=\"container-delete\">\n" +
                "        <div class=\"project-input\">\n" +
                "            select project id to delete \n" +
                "            <form action=\"./project-servlet\" method=\"post\">\n" +
                "                    <input type=\"text\" name=\"id_project\", placeholder=\"Id\">\n" +
                "                    <button type=\"submit\">Delete</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>");

        out.println("<h1>");
        out.println("Commands");
        out.println("</h1>");
        out.println(
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
                        "                <thead>\n" +
                        "                    <tr>\n" +
                        "                        <th>id</th>\n" +
                        "                        <th>persons</th>\n" +
                        "                    </tr>\n" +
                        "                </thead>"
        );
        out.println("<tbody>");
        List<Command> commands = commandService.findAll();
        for (int i = 0; i < commands.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + commands.get(i).getId());

            out.println("<td>");
            for (var person : commands.get(i).getPersons()) {
                out.print(person + ", ");
            }

            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "        <div class=\"command-input\">\n" +
                        "            Fill the table Command\n" +
                        "            <form action=\"./command-servlet\" method=\"post\" required=true>\n" +
                        "                    <input type=\"text\" name=\"id\", placeholder=\"Id\" required=true>\n" +
                        "                    <label for=\"id_persons\">Enter the person name separated by commas:</label>\n" +
                        "                    <input type=\"text\" name=\"id_persons\" id=\"id_persons\" required=true>\n" +
                        "                    <button type=\"submit\">Save</button>\n" +
                        "            </form>\n" +
                        "        </div>\n");

        out.println("    <div class=\"container-delete\">\n" +
                "        <div class=\"command-input\">\n" +
                "            select command id to delete \n" +
                "            <form action=\"./command-servlet\" method=\"post\">\n" +
                "                    <input type=\"text\" name=\"command_id\", placeholder=\"Id\">\n" +
                "                    <button type=\"submit\">Delete</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>");

        out.println("</body></html>");
    }
}