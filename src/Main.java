import dao.impl.AnimalDaoImpl;
import dao.impl.PersonDaoImpl;
import database.DataBase;
import enums.Gender;
import model.Animal;
import model.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        PersonDaoImpl personDao = new PersonDaoImpl(dataBase);
        PersonServiceImpl personService = new PersonServiceImpl(personDao);
        AnimalDaoImpl animalDao = new AnimalDaoImpl(dataBase);
        AnimalServiceImpl animalService = new AnimalServiceImpl(animalDao);
        List<Person> people = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        people.add(new Person("Ajybek", 16, Gender.MALE));
        people.add(new Person("Myrzaiym", 20, Gender.FEMALE));
        people.add(new Person("Kudaiberdi", 17, Gender.MALE));
        people.add(new Person("Urmat", 19, Gender.MALE));
        people.add(new Person("Atabek", 21, Gender.MALE));
        people.add(new Person("Eldiar", 18, Gender.MALE));
        people.add(new Person("Nurmuhammed", 20, Gender.MALE));
        personService.add(people);
        System.out.println("Added people: ");
        for (Person person : personService.getAll()) {
            System.out.println(person);
        }
        System.out.println();
        OuterLoop:
        while (true) {
            System.out.println("""
                    1.  ADD PERSON
                    2.  ADD ANIMAL
                    3.  GET PERSON BY ID
                    4.  GET ANIMAL BY ID
                    5.  GET ALL PEOPLE
                    6.  GET ALL ANIMALS
                    7.  SORT BY NAME PEOPLE
                    8.  SORT ANIMALS BY NAME
                    9.  FILTER PEOPLE BY GENDER
                    10. FILTER ANIMALS BY GENDER
                    11. CLEAR PEOPLE
                    12. CLEAR ANIMALS
                    """);
            switch (scanner.nextLine()) {
                case "1" -> {
                    List<Person> people1 = new ArrayList<>();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = new Scanner(System.in).nextInt();
                    System.out.println("GENDER: \n1-MALE  2-FEMALE");
                    String answer = scanner.nextLine();
                    Gender gender = null;
                    if (answer.equals("1") || answer.toLowerCase().equals("male")) {
                        gender = Gender.MALE;
                    } else if (answer.equals("2") || answer.toLowerCase().equals("female")) {
                        gender = Gender.FEMALE;
                    } else System.out.println("Cant be another gender!");
                    people1.add(new Person(name, age, gender));
                    System.out.println(personService.add(people1));
                }
                case "2" -> {
                    List<Animal> animalList = new ArrayList<>();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = new Scanner(System.in).nextInt();
                    System.out.println("GENDER: \n1-MALE  2-FEMALE");
                    String answer = scanner.nextLine();
                    Gender gender = null;
                    if (answer.equals("1") || answer.toLowerCase().equals("male")) {
                        gender = Gender.MALE;
                    } else if (answer.equals("2") || answer.toLowerCase().equals("female")) {
                        gender = Gender.FEMALE;
                    } else System.out.println("Cant be another gender!");
                    animalList.add(new Animal(name, age, gender));
                    System.out.println(animalService.add(animalList));
                }
                case "3" -> {
                    System.out.println("Enter id:");
                    Long id = new Scanner(System.in).nextLong();
                    try {
                        System.out.println(personService.getById(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "4" -> {
                    System.out.println("Enter id:");
                    Long id = new Scanner(System.in).nextLong();
                    try {
                        System.out.println(animalService.getById(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "5" -> {
                    try {
                        for (Person person : personService.getAll()) {
                            System.out.println(person);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "6" -> {
                    for (Animal animal : animalService.getAll()) {
                        System.out.println(animal);
                    }
                }
                case "7" -> {
                    for (Person person : personService.sortByName()) {
                        System.out.println(person);
                    }
                }
                case "8" -> {
                    for (Animal animal : animalService.sortByName()) {
                        System.out.println(animal);
                    }
                }
                case "9" -> {
                    for (Person person : personService.filterByGender()) {
                        System.out.println(person);
                    }
                }
                case "10" -> {
                    for (Animal animal : animalService.filterByGender()) {
                        System.out.println(animal);
                    }
                }
                case "11" -> {
                    System.out.println(personService.clear());
                }
                case "12" -> {
                    System.out.println(animalService.clear());
                }
            }
        }
    }
}