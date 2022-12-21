package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "shooping_cart")
public class ShoppingCart {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.EAGER)
    private List<Order> orders;

}
