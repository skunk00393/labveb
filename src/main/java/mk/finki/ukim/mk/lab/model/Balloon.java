package mk.finki.ukim.mk.lab.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "balloon_table")
public class Balloon {

    @Id
    private Long id;

    public String name;
    public String description;

    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(String name, String description, Manufacturer manufacturer){
        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
        this.manufacturer=manufacturer;
    }

    public Balloon() {

    }
}
