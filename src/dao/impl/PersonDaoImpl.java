package dao.impl;

import dao.GenericDao;
import database.DataBase;
import model.Person;

import java.lang.module.FindException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonDaoImpl implements GenericDao<Person> {
    private final DataBase dataBase;

    public PersonDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    Long id = 0L;
    @Override
    public String add(List<Person> t) {
        for (Person person : t) {
            dataBase.personList.add(person);
            person.setId(++id);
        }
        return "Successfully added!";
    }

    @Override
    public Person getById(Long id) {
        Person person1 = null;
        try {
            for (Person person : dataBase.personList) {
                if (person.getId().equals(id)) {
                    person1 = person;
                }
            }
        } catch (Exception e) {
            System.out.println("Person with id " + id + " not found!");
        }
        return person1;
    }

    @Override
    public List<Person> getAll() {
        try {
            return dataBase.personList;
        } catch (FindException e) {
            System.out.println("Person list is empty!");
        }
        return null;
    }

    @Override
    public List<Person> sortByName() {
        dataBase.personList.sort(Comparator.comparing(Person::getName));
        return dataBase.personList;
    }

    @Override
    public List<Person> filterByGender() {
        dataBase.personList.sort(Comparator.comparing(Person::getGender));
        return dataBase.personList;
    }

    @Override
    public List<Person> clear() {
        dataBase.personList.clear();
        return dataBase.personList;
    }

}
