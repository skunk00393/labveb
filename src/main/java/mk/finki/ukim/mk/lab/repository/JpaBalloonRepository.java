package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaBalloonRepository extends JpaRepository<Balloon, Long> {

    @Query("select bl from Balloon bl where bl.name = :name or bl.description=:description")
    List<Balloon> findAllByNameOrDescription(String name, String description);

}
