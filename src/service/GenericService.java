package service;

import java.util.List;

public interface GenericService <T>{
    String add(List<T> t);
    T getById(Long id) throws Exception;
    List<T> getAll() throws Exception;
    List<T> sortByName(); // if press 1 ascending, 2 descending
    List<T> filterByGender(); //if press 1 female, 2 male
    List<T> clear();
}
