package com.prep.eventmanagement.service;


import com.prep.eventmanagement.dto.EventRequestDTO;
import com.prep.eventmanagement.dto.EventResponseDTO;
import java.util.List;

public interface EventService {

    EventResponseDTO create(EventRequestDTO dto);

    EventResponseDTO get(Long id);

    List<EventResponseDTO> getAll();

    EventResponseDTO update(Long id, EventRequestDTO dto);

    void delete(Long id);
}


