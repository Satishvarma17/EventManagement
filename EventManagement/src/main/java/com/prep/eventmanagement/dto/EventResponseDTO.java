package com.prep.eventmanagement.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
public class EventResponseDTO {

    private Long id;
    private String name;
    private String location;
    private LocalDateTime eventDate;
    private int capacity;
}
