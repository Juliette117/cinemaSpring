package com.example.cinemaspring.ticket;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Integer id) {
        return this.ticketRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ce ticket n'est pas attribué"
                )
        );
    }

    public Ticket save(Ticket ticket) {

        return ticketRepository.save(ticket);
    }
    public void delete(Integer id) {
        Ticket ticket = this.findById(id);
        this.ticketRepository.delete(ticket);
    }

    public Ticket update(Integer id) {
        Ticket ticket = this.findById(id);
        ticketRepository.save(ticket);
        return ticket;
    }



}

