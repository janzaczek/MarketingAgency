package project.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import project.personal.enums.Plec;
import project.personal.enums.ProductionType;
import project.personal.model.Person;
import project.personal.model.Production;
import project.personal.repository.PersonRepository;
import project.personal.repository.ProductionRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class PersonalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(PersonalApplication.class, args);
		PersonRepository personRepository = cac.getBean(PersonRepository.class);
		ProductionRepository productionRepository = cac.getBean(ProductionRepository.class);

		Production production1 = new Production();
		production1.setType(ProductionType.ADVERTISEMENT);
		production1.setDate(LocalDate.of(2020,10,16));
		production1.setLink("Jakiś link");
		productionRepository.save(production1);

		Production production2 = new Production();
		production2.setType(ProductionType.TVSERIES);
		production2.setDate(LocalDate.now());
		productionRepository.save(production2);

		Person p1 = new Person();
		p1.setName("Jan");
		p1.setSurname("Kowalski");
		p1.setGender(Plec.MEZCZYZNA);
		p1.setAge(50);
		p1.setPhoneNumber("123456789");
		p1.setEmail("jan.kowalski@gmail.com");
		p1.addProduction(production1);
		personRepository.save(p1);

		Person p2 = new Person();
		p2.setName("Ola");
		p2.setSurname("Kot");
		p2.setGender(Plec.KOBIETA);
		p2.setAge(22);
		p2.setPhoneNumber("987654321");
		p2.setEmail("KotOla@wp.pl");
		p2.addProduction(production1);
		p2.addProduction(production2);
		personRepository.save(p2);

	}

}
