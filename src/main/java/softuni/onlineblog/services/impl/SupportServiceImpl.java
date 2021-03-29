package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Ticket;
import softuni.onlineblog.repositories.TicketRepository;
import softuni.onlineblog.services.SupportService;

import java.time.LocalDateTime;

@Service
public class SupportServiceImpl implements SupportService {
    private TicketRepository ticketRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SupportServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTicket(String subject, String message, String email) {
       Ticket ticket=new Ticket(email,subject,message,false, LocalDateTime.now(),null);
       ticketRepository.save(ticket);

    }
}
