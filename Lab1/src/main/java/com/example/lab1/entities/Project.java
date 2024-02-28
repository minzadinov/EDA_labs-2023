package com.example.lab1.entities;

import com.example.lab1.dto.ProjectDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {
    @Id

    private Long id;

    private String project_name;

    private int budget;

    private Long command_id;

    public Project(ProjectDTO projectDTO) {
        this.id = projectDTO.getId();
        this.project_name = projectDTO.getProject_name();
        this.budget = projectDTO.getBudget();
        this.command_id = projectDTO.getCommandId();
    }
}
