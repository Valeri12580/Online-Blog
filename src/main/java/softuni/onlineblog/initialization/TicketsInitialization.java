package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Ticket;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.repositories.TicketRepository;
import softuni.onlineblog.repositories.UserRepository;

import java.util.*;
import java.time.LocalDateTime;


@Component
@Order(6)
public class TicketsInitialization implements CommandLineRunner {
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketsInitialization(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin=userRepository.findUserByUsername("valeri").get();
        Ticket ticket=new Ticket("valeri@abv.bg","Saita vi ne bachka kato horata.....",
                "Zdraveite, ot nqkolko dni saita ne raboti kato horata, opravete go be...",false, LocalDateTime.now()
        ,null);
        Ticket ticketTwo=new Ticket("ivan@abv.bg","Problem with logout",
                "Hello i have some problems with the logout...i cant logout, please fix it :(((",false, LocalDateTime.now()
                ,admin);

        ticketRepository.saveAll(List.of(ticket,ticketTwo));
    }
}
