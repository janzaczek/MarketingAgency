package project.personal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import project.personal.enums.Plec;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Enumerated(EnumType.STRING)
    private Plec gender;

    @Column
    private Integer age;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    // this merge is ok for h2 database, but when it comes to real database probably there should also be persist next
    // to merge annotation
    @ManyToMany(
            cascade = {CascadeType.MERGE}
    )
    @JoinTable(
            name = "person_production",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "productions_id")
    )
    @JsonIgnoreProperties("people") // this annotation seems to work with circular JSON problem
    private List<Production> productions = new ArrayList<>();

    public void addProduction(Production production){
        this.productions.add(production);
        production.getPeople().add(this);
    }

    public void removeProduction(Production production){
        this.productions.remove(production);
        production.getPeople().remove(this);
    }
}
