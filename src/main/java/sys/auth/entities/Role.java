package sys.auth.entities;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Role {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName roleName;

    public Role(RoleName roleName) {
        roleName = roleName;
    }

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        roleName = roleName;
    }
}
