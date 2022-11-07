package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        List<Balloon> balloonList = balloonRepository.findAllBalloons();
        balloonList.sort(Comparator.comparing(Balloon::getName));
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> findById(int id) {
        return balloonRepository.findById(id);
    }

    @Override
    public void add(String name, String description, int manId) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manId);
        manufacturer.ifPresent(value -> balloonRepository.addBalloon(name, description, value));
    }


    @Override
    public void edit(int id,String name, String description, int manId) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manId);
        Optional<Balloon> balloon = balloonRepository.findById(id);
        if(manufacturer.isPresent()){
            if(balloon.isPresent()){
                Balloon balloonFound = balloon.get();
                balloonFound.setName(name);
                balloonFound.setDescription(description);
                balloonFound.setManufacturer(manufacturer.get());
                balloonRepository.editBalloon(id,balloonFound);
            }
        }
    }

    @Override
    public void remove(int id) {
        balloonRepository.deleteById(id);
    }
}
