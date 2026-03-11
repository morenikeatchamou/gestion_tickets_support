package com.example.gestion_tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom; 
    private String motif_ticket;

    public Ticket(){

    }
    public Ticket(int id, String nom, String motif_ticket){
        this.id= id;
        this.nom= nom;
        this.motif_ticket= motif_ticket;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMotif_ticket() {
        return motif_ticket;
    }
    public void setMotif_ticket(String motif_ticket) {
        this.motif_ticket = motif_ticket;
    } 
    
}
