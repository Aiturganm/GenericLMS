package dao;

import java.util.List;

public interface GenericDao<T> {
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(); // if press 1 ascending, 2 descending
    List<T> filterByGender(); //if press 1 female, 2 male
    List<T> clear();
}
