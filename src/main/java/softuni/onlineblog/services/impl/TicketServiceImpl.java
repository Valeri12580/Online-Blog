package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.repositories.TicketRepository;
import softuni.onlineblog.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTicket(String subject, String message, String email) {

    }
}
