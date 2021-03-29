package softuni.onlineblog.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @Column
    private String email;

    @Column
    private String subject;

    @Column
    private String message;

    @Column
    private boolean isResolved;

    @Column
    private LocalDateTime createdOn;

}
