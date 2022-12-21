package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    User createNew(String username, String name, String surname, String password, Role role);

}
