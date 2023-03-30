package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.administration.Person;
import ro.pao.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor

public class PersonServiceImpl implements PersonService
{
    private static List<Person> personList = new ArrayList<>();
    @Override
    public Optional<Person> getById(UUID id)
    {
        return personList.stream().filter(obj -> id.equals(obj.getReaderID())).findAny();
    }

    @Override
    public List<Person> getAll()
    {
        return personList;
    }
    @Override
    public void addOne(Person person)
    {
        personList.add(person);
    }

    @Override
    public void removeById(UUID id)
    {
        personList = personList.stream().filter(element -> !id.equals(element.getReaderID())).collect(Collectors.toList());
    }

    @Override
    public void modifyById(UUID id, Person newPerson)
    {
        removeById(id);
        addOne(newPerson);
    }


}
