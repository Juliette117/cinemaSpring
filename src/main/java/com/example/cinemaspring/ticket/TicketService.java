package com.example.cinemaspring.ticket;
import com.example.cinemaspring.film.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

        erreursTicket(ticket);

        return ticketRepository.save(ticket);
    }

    private static void erreursTicket(Ticket ticket) {

        List<String> erreurs = new ArrayList<>();

        if (ticket.getSeance() == null) {
            erreurs.add("Le choix d'une séance est obligatoire");
        }

        if (ticket.getNomClient().isEmpty()) {
            erreurs.add("Le nom du client est obligatoire");
        }

        if(ticket.getNombrePlaces() < 0) {
            erreurs.add("Y a plus de place");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
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
    public void updateById(Ticket ticket, Integer id) {
        this.findById(id);
        ticket.setId(id);
        this.ticketRepository.save(ticket);
    }





}

