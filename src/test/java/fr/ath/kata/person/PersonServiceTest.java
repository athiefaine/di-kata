package fr.ath.kata.person;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonServiceTest {

    @Test
    // the test will fail
    void personService_should_return_exact_count_of_saved_persons() {

        List<Person> persons = Arrays.asList(
                new Person("Pierre", "Martinet"),
                new Person("Odile", "Croq"));

        PersonService personService = new PersonService();

        persons.forEach(personService::save);

        assertThat(personService.getMobSize()).isEqualTo(persons.size());

    }

}