package sys.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.auth.entities.Role;
import sys.auth.entities.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
