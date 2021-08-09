package project.personal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.personal.enums.ProductionType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "productions")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductionType type;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column
    private String link;

    @ManyToMany(mappedBy = "productions")
    @JsonIgnoreProperties("productions") // this annotation seems to work with circular JSON problem
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person){
        this.people.add(person);
        person.getProductions().add(this);
    }

    public void removePerson(Person person){
        this.people.remove(person);
        person.getProductions().remove(this);
    }
}
