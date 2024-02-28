package com.example.demo.jms;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class WatchDogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String object;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    public WatchDogEntity(String object, EventType eventType) {
        this.object = object;
        this.eventType = eventType;
    }
}
