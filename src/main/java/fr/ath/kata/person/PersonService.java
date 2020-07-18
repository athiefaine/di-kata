package fr.ath.kata.person;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService() {
        personRepository = new PersonRepository();
    }


    public void save(Person person) {
        personRepository.save(person);
    }

    public int getMobSize() {
        return personRepository.findAll().size();
    }
}
