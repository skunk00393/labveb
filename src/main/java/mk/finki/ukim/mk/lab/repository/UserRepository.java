package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
