package softuni.onlineblog.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class Ticket extends BaseEntity {

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String subject;

    @Column
    @NonNull
    private String message;

    @Column
    @NonNull
    private boolean isResolved;

    @Column
    @NonNull
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "resolver_id", referencedColumnName = "id")
    private User resolvedBy;

}
