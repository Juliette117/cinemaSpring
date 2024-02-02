package com.example.cinemaspring.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Integer idTicket) {
        super("Le ticket avec l'indentifiant " + idTicket + "est inexistant");
    }



}
