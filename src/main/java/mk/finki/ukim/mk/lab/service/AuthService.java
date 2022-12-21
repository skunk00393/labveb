package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.exceptions.InvalidArgumentsException;

public interface AuthService {
    User login(String username, String password) throws InvalidArgumentsException;
}
