package softuni.onlineblog.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Role  extends BaseEntity implements GrantedAuthority {
    private String role;
    @Override
    public String getAuthority() {
        return this.role;
    }
}
