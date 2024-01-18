package com.springboot.springbootjpa;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.springbootjpa.entities.Person;
import com.springboot.springbootjpa.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		// create();
		// update();
		// deleteById();
		// getByIdPersonalize();
		consultPersonalize2();
	}

	@Transactional(readOnly = true)
	public void consultPersonalize2() {
		System.out.println("Lista de usuarios");

		List<Person> personList = this.personRepository.findAllClassPerson();
		personList.forEach(person -> System.out
				.println(person.getName().toUpperCase() + " " + person.getLastname().toUpperCase()));
	}

	@Transactional(readOnly = true)
	public void consultPersonalize() {
		System.out.println("Lista de usuarios");

		List<Object[]> personList = this.personRepository.findAllMixPersonDataList();
		personList.forEach(person -> System.out.println(person[0] + " " + person[1] + " " + person[2]));
	}

	@Transactional(readOnly = true)
	public void getByIdPersonalize() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario: ");
		Long idPerson = scanner.nextLong();
		scanner.close();
		String person = this.personRepository.getByIdPersonalize(idPerson);

		System.out.println("Usuario con el id: " + idPerson + " es " + person);
	}

	@Transactional
	public void deleteById() {
		Scanner scanner = new Scanner(System.in);
		// MOSTRAMOS TODOS
		this.personRepository.findAll().forEach(System.out::println);
		System.out.println("Ingrese el id a eliminar: ");

		Long personId = scanner.nextLong();
		scanner.close();
		// Buscamos primero que exista el dato
		Optional<Person> person = this.personRepository.findById(personId);
		// Validamos
		person.ifPresentOrElse(p -> {
			this.personRepository.deleteById(p.getId());
			System.out.println("¡Eliminado con éxito!");
		}, () -> System.out.println("No existe el usuario"));
	}

	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el id de el usuario: ");
		Long idPerson = scanner.nextLong();

		Optional<Person> personOld = this.personRepository.findById(idPerson);
		// personOld.ifPresent(person -> {
		if (personOld.isPresent()) {
			Person person = personOld.orElseThrow();
			System.out.println(person);
			System.out.println("Ingrese los nuevos datos: ");
			String newLanguaje = scanner.next();
			person.setProgrammingLanguage(newLanguaje);
			Person personNew = this.personRepository.save(person);
			log.info("Datos actualizados de la nueva persona: {}" + personNew);
			scanner.close();
		} else {
			System.out.println("¡El usuario no existe!");
		}
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

	@Transactional(readOnly = true)
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

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce un nombre: ");
		String name = scanner.next();
		System.out.println("Introduce un apellido: ");
		String lastname = scanner.next();
		System.out.println("Introduce un lenguaje de programación");
		String programmingLanguaje = scanner.next();
		scanner.close();
		// crear una nueva persona
		Person person = new Person(null, name, lastname, programmingLanguaje);
		// Guardar una nueva persona
		Person personSave = this.personRepository.save(person);
		log.info("Persona nueva registrada: {}", personSave);
		this.personRepository.findById(personSave.getId()).ifPresent((p) -> System.out.println(p));
	}
}
