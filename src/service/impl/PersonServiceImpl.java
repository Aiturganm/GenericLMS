package service.impl;

import dao.impl.PersonDaoImpl;
import model.Person;
import service.GenericService;

import javax.swing.border.EmptyBorder;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @Override
    public String add(List<Person> t) {
        personDao.add(t);
        return "Successfully saved!";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : personDao.getAll()) {
            if (person.getId().equals(id)) {
                return personDao.getById(id);
            }
        }
        throw new FindException();
    }

    @Override
    public List<Person> getAll() {
        if (!personDao.getAll().isEmpty()) {
            return personDao.getAll();
        } else
            throw new FindException();
    }

    @Override
    public List<Person> sortByName() {
        return personDao.sortByName();
    }

    @Override
    public List<Person> filterByGender() {
        return personDao.filterByGender();
    }

    @Override
    public List<Person> clear() {
        return personDao.clear();
    }
}
