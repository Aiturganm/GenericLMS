package service.impl;

import dao.impl.AnimalDaoImpl;
import model.Animal;
import service.GenericService;

import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
    private final AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public String add(List<Animal> t) {
        animalDao.add(t);
        return "Successfully saved!";
    }

    @Override
    public Animal getById(Long id) {
        if(!animalDao.getAll().isEmpty()){
            animalDao.getById(id);
        }
        throw new RuntimeException("Animal with id " + id + " not found!");
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName() {
        return animalDao.sortByName();
    }

    @Override
    public List<Animal> filterByGender() {
        return animalDao.filterByGender();
    }

    @Override
    public List<Animal> clear() {
        return animalDao.clear();
    }
}
