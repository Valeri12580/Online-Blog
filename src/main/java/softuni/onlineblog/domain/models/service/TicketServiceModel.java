package softuni.onlineblog.domain.models.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.onlineblog.domain.entities.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TicketServiceModel extends BaseServiceModel {
    private String email;

    private String subject;

    private String message;

    private boolean isResolved;

    private LocalDateTime createdOn;

    private User resolvedBy;
}
