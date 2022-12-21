package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.JpaBalloonRepository;
import mk.finki.ukim.mk.lab.repository.JpaManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {


    private final JpaBalloonRepository jpaBalloonRepository;
    private final JpaManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(JpaBalloonRepository jpaBalloonRepository, JpaManufacturerRepository manufacturerRepository) {
        this.jpaBalloonRepository = jpaBalloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        List<Balloon> balloonList = jpaBalloonRepository.findAll();
        balloonList.sort(Comparator.comparing(Balloon::getName));
        return balloonList;
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return jpaBalloonRepository.findAllByNameOrDescription(text,text);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return jpaBalloonRepository.findById(id);
    }

    @Override
    public Balloon add(String name, String description, Long manId) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manId);
        manufacturer.ifPresent(value -> jpaBalloonRepository.save(new Balloon(name, description, manufacturer.get())));
        return null;
    }


    @Override
    public void edit(Long id,String name, String description, Long manId) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manId);
        Optional<Balloon> balloon = jpaBalloonRepository.findById(id);
        if(manufacturer.isPresent()){
            if(balloon.isPresent()){
                Balloon balloonFound = balloon.get();
                balloonFound.setName(name);
                balloonFound.setDescription(description);
                balloonFound.setManufacturer(manufacturer.get());
                jpaBalloonRepository.save(balloonFound);
            }
        }
    }

    @Override
    public void remove(Long id) {
        jpaBalloonRepository.deleteById(id);
    }
}
