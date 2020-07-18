package fr.ath.kata.person;

import java.util.List;

public class PersonRepository {

    public void save(Person person) {
        throw new DatabaseNotAvailableException();
    }

    public List<Person> findAll() {
        throw new DatabaseNotAvailableException();
    }
}
