package com.springboot.springbootjpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.springbootjpa.entities.Person;
import com.springboot.springbootjpa.repository.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// list();
		// findById();
		create();
	}

	public void list() {
		// List<Person> persons = (List<Person>) personRepository.findAll();
		// List<Person> persons = (List<Person>)
		// this.personRepository.findByProgrammingLanguage("Java");

		List<Person> persons = (List<Person>) this.personRepository.findByProgrammingLanguageAndName("Java", "Josefa");

		System.out.println("****    RESULTADO CONSULTA 1    ****");
		persons.stream().forEach(System.out::println);
		System.out.println("****    FIN CONSULTA    ****");
		System.out.println();

		List<Object[]> persons2 = this.personRepository.getPersonValues();
		System.out.println("****    RESULTADO CONSULTA 2    ****");
		persons2.stream().forEach((person) -> {
			System.out.println(person[0] + " es estudiante de: " + person[1]);
		});
		System.out.println("****    FIN CONSULTA    ****");
	}

	public void findById() {

		// Optional<Person> person = this.personRepository.findById(1L);
		// if (!person.isPresent()) {
		// throw new NoSuchElementException();
		// }
		// System.out.println();
		// System.out.println("Usuario con ID: " +
		// person.get().getId() +
		// " es " +
		// person.get().getName() +
		// " " +
		// person.get().getLastname()
		// + " y estudia: " +
		// person.get().getProgrammingLanguage());
		// System.out.println();

		/* De formas mas simplificada */
		// this.personRepository.findById(1L).ifPresent((person) ->
		// System.out.println(person));
		// this.personRepository
		// .findOneName("Josefa")
		// .ifPresent(System.out::println);

		this.personRepository
				.findByNameContaining("p")
				.ifPresent(System.out::println);
	}

	public void create() {
		// crear una nueva persona
		Person person = new Person(null, "Lizandro", "Narváez", "Java-SpringBoot");
		// Guardar una nueva persona
		this.personRepository.save(person);
	}
}
