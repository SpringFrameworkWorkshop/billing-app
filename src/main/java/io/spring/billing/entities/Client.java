package io.spring.billing.entities;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Client implements BillingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Bill> bills;

    @Embedded
    private Audit audit = new Audit();

    @Override
    public String toString() {
        return String.format("\t\n{id: %s, name: %s, surname: %s, email: %s}",
                getId(), getName(), getSurname(), getEmail());
    }

}
