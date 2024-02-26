package com.example.cinemaspring.ticket;

import com.example.cinemaspring.seance.Seance;
import com.example.cinemaspring.ticket.dto.TicketCompletDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final ObjectMapper objectMapper;

    public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
        this.ticketService = ticketService;
        this.objectMapper = objectMapper;
    }

    //GET
    @GetMapping
    public List<TicketCompletDto> findAll() {
        List<Ticket> tickets = this.ticketService.findAll();
        return tickets.stream().map(
                ticket -> objectMapper.convertValue(
                        ticket, TicketCompletDto.class
                )
        ).toList();
    }

    //GET /tickets/id
    @GetMapping("/{id}")
    public TicketCompletDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(
                this.ticketService.findById(id),
                TicketCompletDto.class
        );
    }

    //POST /tickets
    @PostMapping
    public TicketCompletDto save(@RequestBody Ticket ticket) {
        return objectMapper.convertValue(
                this.ticketService.save(ticket),
                TicketCompletDto.class
        );
    }

    //PUT /tickets/id
    @PutMapping("/{id}")
    public TicketCompletDto update(@RequestBody Ticket ticket, @PathVariable Integer id) {
        return objectMapper.convertValue(
                this.ticketService.update(ticket, id),
                TicketCompletDto.class
        );
    }

    //DELETE /tickets/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        this.ticketService.delete(id);
    }








}
