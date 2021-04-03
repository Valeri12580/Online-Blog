package softuni.onlineblog.domain.models.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.onlineblog.domain.models.service.TicketServiceModel;
import java.util.*;

@Data
@NoArgsConstructor
public class TicketsPageModel {
    private int totalPages;
    private List<TicketServiceModel>tickets;
}
