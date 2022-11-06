package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    List<Balloon> balloonList = Arrays.asList(new Balloon("1","2"),new Balloon("1","2"),
                                              new Balloon("1","2"),new Balloon("1","2"),
                                              new Balloon("1","2"),new Balloon("1","2"),
                                              new Balloon("1","2"),new Balloon("1","2"),
                                              new Balloon("1","2"),new Balloon("1","2"));


    public List<Balloon> findAllBalloons(){
        return balloonList;
    };

    public List<Balloon> findAllByNameOrDescription(String text){
        return balloonList.stream().filter(item -> item.name.equals(text) || item.description.equals(text)).collect(Collectors.toList());
    };

}
