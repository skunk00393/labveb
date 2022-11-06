package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ManufacturerRepository {

    List<Manufacturer> manufacturerList = new ArrayList<>();

    public List<Manufacturer> findAll(){
        return manufacturerList;
    }

}
