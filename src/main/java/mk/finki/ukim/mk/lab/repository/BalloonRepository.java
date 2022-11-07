package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    };
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream().filter(item -> item.name.equals(text) || item.description.equals(text)).collect(Collectors.toList());
    };

    public Optional<Balloon> findById(int balloonId){
        return DataHolder.balloonList.stream().filter(item -> item.getId().equals((long) balloonId)).findFirst();
    }
    public void addBalloon(String name, String description, Manufacturer manufacturer){
        DataHolder.balloonList.add(new Balloon(name,description,manufacturer));
    }

    public void editBalloon(int id, Balloon balloonFound) {
        for(int i=0;i<DataHolder.balloonList.size();i++){
            if(DataHolder.balloonList.get(i).getId().equals((long)id)){
                DataHolder.balloonList.get(i).setName(balloonFound.getName());
                DataHolder.balloonList.get(i).setDescription(balloonFound.getDescription());
                DataHolder.balloonList.get(i).setManufacturer(balloonFound.getManufacturer());
            }
        }
    }

    public void deleteById(int id) {
        for(int i=0;i<DataHolder.balloonList.size();i++){
            if(DataHolder.balloonList.get(i).getId().equals((long)id)){
                DataHolder.balloonList.remove(i);
                break;
            }
        }
    }
}
