package com.prep.eventmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @Future(message = "Event date must be in the future")
    private LocalDateTime eventDate;

    @Positive(message = "Capacity must be greater than 0")
    private int capacity;
}
