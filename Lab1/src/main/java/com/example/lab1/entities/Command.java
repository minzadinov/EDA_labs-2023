package com.example.lab1.entities;

import com.example.lab1.dto.CommandDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commands")
public class Command {
    @Id
    private Long id;

    @ElementCollection
    private List<String> persons = new ArrayList<>();

    public Command(CommandDTO commandDTO) {
        this.id = commandDTO.getId();
        this.persons = commandDTO.getPersons();
    }
}
