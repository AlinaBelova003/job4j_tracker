package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary  {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> combine = person -> person.getName().contains(key)
                || person.getPhone().contains(key)
                || person.getAddress().contains(key)
                || person.getSurname().contains(key);
        return persons.stream()
                .filter(combine)
                .collect(Collectors.toList());
    }
}
