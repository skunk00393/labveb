package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "orders")
public class Order {

    String balloonColor;

    String balloonSize;

    @ManyToOne
    private ShoppingCart shoppingCart;
    @Id
    Long orderId;
}
