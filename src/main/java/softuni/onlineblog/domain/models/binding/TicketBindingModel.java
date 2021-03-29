package softuni.onlineblog.domain.models.binding;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class TicketBindingModel {


    @NotEmpty
    @Size(min = 10,max = 70)
    private String subject;

    @NotEmpty
    @Size(min = 70,max = 1000)
    private String message;

    @NotEmpty
    @Email
    private String email;
}
