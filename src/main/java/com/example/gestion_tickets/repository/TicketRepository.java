package com.example.gestion_tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion_tickets.entity.Ticket;

public interface TicketRepository extends JpaRepository <Ticket, Integer>{
    
}
