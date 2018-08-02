package io.spring.billing.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"id"})
@NamedQueries({
        @NamedQuery(name="Product.findProductByPriceLessThan",
                query="SELECT p FROM Product p WHERE p.price < :price")
})
public class Product implements BillingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @Embedded
    private Audit audit = new Audit();

    @Override
    public String toString() {
        return String.format("\t\n{id: %s, name: %s, price: %s}",
                getId(), getName(), getPrice());
    }
}
