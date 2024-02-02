package com.example.cinemaspring.ticket;

import com.example.cinemaspring.seance.Seance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //GET
    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    //GET /tickets/id
    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Integer id) {
        return this.ticketService.findById(id);
    }

    //POST /tickets
    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {

        return ticketService.save(ticket);
    }

    //DELETE /tickets/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        this.ticketService.delete(id);
    }

    //PUT /tickets
    @PutMapping
    public Ticket update(@RequestBody Ticket ticket) {

        return ticketService.save(ticket);
    }

    //PUT /tickets/id
    @PutMapping("/{id}")
    public Ticket updateById(@RequestBody Ticket ticket, @PathVariable Integer id) {
        this.ticketService.update(id);
        return ticket;
    }



}
