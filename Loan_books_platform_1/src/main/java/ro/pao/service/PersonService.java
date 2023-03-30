package ro.pao.service;

import ro.pao.model.administration.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface PersonService
{
    Optional<Person> getById(UUID id);
    List<Person> getAll();
    //void addAll(List<Person> personList);
    void addOne(Person person);
    void removeById(UUID id);
    void modifyById(UUID id, Person newPerson);
}
