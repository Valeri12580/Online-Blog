package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Ticket;
import softuni.onlineblog.domain.models.service.TicketServiceModel;
import softuni.onlineblog.domain.models.view.TicketsPageModel;
import softuni.onlineblog.repositories.TicketRepository;
import softuni.onlineblog.services.SupportService;
import softuni.onlineblog.util.Constants;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
        Ticket ticket = new Ticket(email, subject, message, false, LocalDateTime.now(), null);
        ticketRepository.save(ticket);

    }


    @Override
    public TicketsPageModel getTickets(int page) {
        PageRequest pageR = PageRequest.of(page, Constants.PAGE_SIZE);


        Page<Ticket> all = ticketRepository.findAll(pageR);


        return getTicketPageModel(all);
    }


    private TicketsPageModel getTicketPageModel(Page<Ticket> tickets) {
        List<TicketServiceModel> ticketsServiceModel = Arrays.asList(this.modelMapper.map(tickets.getContent(), TicketServiceModel[].class));

        TicketsPageModel ticketsPageModel = new TicketsPageModel();
        ticketsPageModel.setTickets(ticketsServiceModel);
        ticketsPageModel.setTotalPages(tickets.getTotalPages());

        return ticketsPageModel;
    }


}
