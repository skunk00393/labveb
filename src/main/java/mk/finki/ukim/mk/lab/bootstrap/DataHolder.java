package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();

    @PostConstruct
    public void init(){

        manufacturerList.add(new Manufacturer("man1","mk", "skopje"));
        manufacturerList.add(new Manufacturer("man2","srb", "belgrade"));
        manufacturerList.add(new Manufacturer("man3","us", "chicago"));
        manufacturerList.add(new Manufacturer("man4","uk", "london"));
        manufacturerList.add(new Manufacturer("man5","ger", "dortmund"));

        balloonList.add(new Balloon("Crven","Crven",manufacturerList.get(0)));
        balloonList.add(new Balloon("Crven","Crven",manufacturerList.get(0)));
        balloonList.add(new Balloon("Zholt","Zholt",manufacturerList.get(1)));
        balloonList.add(new Balloon("Zelen","Zelen",manufacturerList.get(1)));
        balloonList.add(new Balloon("Violetov","Violetov",manufacturerList.get(2)));
        balloonList.add(new Balloon("Portokalov","Portokalov",manufacturerList.get(2)));
        balloonList.add(new Balloon("Bel","Bel",manufacturerList.get(3)));
        balloonList.add(new Balloon("Crn","Crn",manufacturerList.get(3)));
        balloonList.add(new Balloon("Kafen","Kafen",manufacturerList.get(4)));
        balloonList.add(new Balloon("Rozev","Rozev",manufacturerList.get(4)));
    }

}
