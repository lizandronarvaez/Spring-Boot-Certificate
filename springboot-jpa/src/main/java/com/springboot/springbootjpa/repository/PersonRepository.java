package com.springboot.springbootjpa.repository;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.springbootjpa.dto.PersonDto;
import com.springboot.springbootjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    // Son consultas personalizadas en funcion de los atributos
    /* LISTAS */

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    // COnsultas personalizadas con query
    /* LISTAS PERO CON QUERYS */
    @Query("SELECT p FROM Person p WHERE p.programmingLanguage=?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> getPersonValues();

    //
    @Query("SELECT p FROM Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT p FROM Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    // Buscar por Like
    Optional<Person> findByNameContaining(String name);

    // Buscar por el nombre
    @Query("SELECT p.name FROM Person p WHERE p.id=?1")
    String getByIdPersonalize(Long id);

    // Buscar lista de objetos
    @Query("SELECT p.name,p.lastname,p.programmingLanguage FROM Person p")
    List<Object[]> findAllMixPersonDataList();

    // Lista de personas
    @Query("SELECT new Person(p.name,p.lastname) FROM Person p")
    List<Person> findAllClassPerson();

    // LIsta de personas 2
    @Query("SELECT new com.springboot.springbootjpa.dto.PersonDto(p.name,p.lastname) FROM Person p")
    List<PersonDto> findAllClassPersonDto();

    // Lista de nombre de personas
    @Query("SELECT p.name FROM Person p")
    List<String> findAllNames();

    // OCULTAR REPETIDOS
    @Query("SELECT DISTINCT(p.programmingLanguage) FROM Person p")
    List<String> findAllLanguagesDisticnt();

}
