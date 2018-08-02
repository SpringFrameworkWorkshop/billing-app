package io.spring.billing.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"id"})
@NamedQueries({
        @NamedQuery(name="Client.findByEmail", query="SELECT c FROM Client c WHERE c.email = :email")
})
public class Client implements BillingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Bill> bills = new ArrayList<>();

    @Embedded
    private Audit audit = new Audit();

    @Override
    public String toString() {
        return String.format("\t\n{id: %s, name: %s, surname: %s, email: %s}",
                getId(), getName(), getSurname(), getEmail());
    }

}
