package softuni.onlineblog.domain.models.binding;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketBindingModel {
    private String subject;
    private String message;
    private String email;
}
