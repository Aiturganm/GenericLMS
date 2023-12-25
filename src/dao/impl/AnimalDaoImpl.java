package dao.impl;

import dao.GenericDao;
import database.DataBase;
import model.Animal;

import java.lang.module.FindException;
import java.util.Comparator;
import java.util.List;

public class AnimalDaoImpl implements GenericDao<Animal> {
    private final DataBase dataBase;

    public AnimalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    Long id =0L;
    @Override
    public String add(List<Animal> t) {
        for (Animal animal : t) {
            dataBase.animalList.add(animal);
            animal.setId(++id);
        }
        return "Successfully saved!";
    }

    @Override
    public Animal getById(Long id) {
        Animal animal1 = null;
        try {
            for (Animal animal : dataBase.animalList) {
                if (animal.getId().equals(id)) {
                    animal1 = animal;
                }
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return animal1;
    }

    @Override
    public List<Animal> getAll() {
        return dataBase.animalList;
    }

    @Override
    public List<Animal> sortByName() {
        dataBase.animalList.sort(Comparator.comparing(Animal::getName));
        return dataBase.animalList;
    }

    @Override
    public List<Animal> filterByGender() {
        dataBase.animalList.sort(Comparator.comparing(Animal::getGender));
        return dataBase.animalList;
    }

    @Override
    public List<Animal> clear() {
        dataBase.animalList.clear();
        return dataBase.animalList;
    }
}
