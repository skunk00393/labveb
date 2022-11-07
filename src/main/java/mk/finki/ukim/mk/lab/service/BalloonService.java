package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(int id);

    void add(String name, String description, int manId);

    void edit(int id,String name, String description, int manId);

    void remove(int id);
}
