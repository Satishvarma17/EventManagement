package com.prep.eventmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class EventRequestDTO {

    @NotBlank(message = "Event name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @Future(message = "Event date must be future")
    private LocalDateTime eventDate;

    @Positive(message = "Capacity must be greater than 0")
    private int capacity;
}
