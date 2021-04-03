package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.view.TicketsPageModel;

public interface SupportService {

    void addTicket(String subject, String message, String email);


    TicketsPageModel getTickets(int page);


}
