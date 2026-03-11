    package com.example.gestion_tickets.controllers;

    import java.util.List;

    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.example.gestion_tickets.entity.Ticket;
    import com.example.gestion_tickets.repository.TicketRepository;

    @RestController
    @RequestMapping("/api/tickets")
    public class TicketController {

        private final TicketRepository ticketRepository;

        public TicketController(TicketRepository ticketRepository) {
            this.ticketRepository = ticketRepository;
        }

    //obtenir la liste des tickets
        @GetMapping
    public List <Ticket> getAllTicket(){
        return ticketRepository.findAll();
        }

        //crer un ticket
        @PostMapping
        public Ticket createTicket (@RequestBody Ticket ticket){
            return ticketRepository.save(ticket);
        }

        //lire un ticket 
        @GetMapping("/{id}")
        public Ticket getTicketById(@PathVariable int id){
            return ticketRepository.findById((int) id).orElse(null);
        }

        //mettre à jour un ticket à partir de son id
        @PutMapping("/{id}")
        public Ticket updateTicket(@PathVariable int id, Ticket detail_Ticket){
            Ticket ticket = ticketRepository.findById((int) id).orElse(null);
            if (ticket != null) {
                ticket.setNom(detail_Ticket.getNom());
                ticket.setMotif_ticket(detail_Ticket.getMotif_ticket());
                return ticketRepository.save(ticket);
            }
            return null;
        } 

        //supprimer un ticket 
        @DeleteMapping("/{id}")
        public void deleteTicket (@PathVariable int id){
            ticketRepository.deleteById((int) id);
        }


    }
