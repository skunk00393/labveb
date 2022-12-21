package mk.finki.ukim.mk.lab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "manufacturer_table")
public class Manufacturer {

    @Id
    private Long id;

    private String name;

    private String country;

    private String address;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private List<Balloon> balloonList;

    public Manufacturer(String name, String country, String address){
        this.id = (long) (Math.random()*1000);
        this.name=name;
        this.country=country;
        this.address=address;
    }

    public Manufacturer() {

    }
}
