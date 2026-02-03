package com.prep.eventmanagement.service.impl;

import com.prep.eventmanagement.dto.EventRequestDTO;
import com.prep.eventmanagement.dto.EventResponseDTO;
import com.prep.eventmanagement.model.Event;
import com.prep.eventmanagement.repository.EventRepository;
import com.prep.eventmanagement.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repo;

    @Override
    public EventResponseDTO create(EventRequestDTO dto) {
        Event e = repo.save(Event.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .eventDate(dto.getEventDate())
                .capacity(dto.getCapacity())
                .build());
        return map(e);
    }

    @Override
    public EventResponseDTO get(Long id) {
        Event e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
        return map(e);
    }

    @Override
    public List<EventResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponseDTO update(Long id, EventRequestDTO dto) {
        Event e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        e.setName(dto.getName());
        e.setLocation(dto.getLocation());
        e.setEventDate(dto.getEventDate());
        e.setCapacity(dto.getCapacity());

        return map(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        Event e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
        repo.delete(e);
    }

    private EventResponseDTO map(Event e) {
        return EventResponseDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .location(e.getLocation())
                .eventDate(e.getEventDate())
                .capacity(e.getCapacity())
                .build();
    }
}
