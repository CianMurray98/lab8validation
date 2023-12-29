package ie.atu.lab8springbootvalidation;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/createPerson")
    public ResponseEntity<String> createPerson(@RequestBody @Valid Person person) {
        personService.savePerson(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Person> getPersonByEmployeeId(
            @PathVariable @NotBlank(message = "Employee ID cannot be blank") String employeeId) {
        Person person = personService.getPersonByEmployeeId(employeeId);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
