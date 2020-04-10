package sys.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sys.auth.entities.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface  UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmail(String email);
    User getUserById(Long Id);
    Optional<User> findByUserName(String userName);
    //Boolean existsByUsername(String userName);
    Boolean existsByEmail(String email);
}