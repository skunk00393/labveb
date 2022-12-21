package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);

    Balloon add(String name, String description, Long manId);

    void edit(Long id,String name, String description, Long manId);

    void remove(Long id);
}
