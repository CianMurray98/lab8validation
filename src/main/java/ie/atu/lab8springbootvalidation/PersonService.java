package ie.atu.lab8springbootvalidation;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class PersonService {
    private final Map<String, Person> personData = new HashMap<>();
    public PersonService() {
        // Add a single person as dummy data
        Person dummyPerson = new Person();
        dummyPerson.setName("Cian Murray");
        dummyPerson.setTitle("Student Engineer");
        dummyPerson.setEmployeeId("ABC12345");
        dummyPerson.setAge(25);
        dummyPerson.setEmail("CM98@gmail.com");
        dummyPerson.setPosition("Student Software Developer");
        dummyPerson.setDepartment("R&D");

        personData.put(dummyPerson.getEmployeeId(), dummyPerson);
    }

    public void savePerson(Person person) {
        personData.put(person.getEmployeeId(), person);
        System.out.println("Person saved: " + person);
    }

    public Person getPersonByEmployeeId(String employeeId) {
        return personData.get(employeeId);
    }
}