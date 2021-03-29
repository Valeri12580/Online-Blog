package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
}
