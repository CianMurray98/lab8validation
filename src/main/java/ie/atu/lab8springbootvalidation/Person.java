package ie.atu.lab8springbootvalidation;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Person {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
    private String name;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Employee ID cannot be blank")
    @Size(min = 5, max = 10, message = "Employee ID must be between 5 and 10 characters")
    private String employeeId;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 120, message = "Age must be less than or equal to 120")
    private Integer age;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Position cannot be blank")
    private String position;

    @NotBlank(message = "Department cannot be blank")
    private String department;

    // Constructors, getters, setters, and other methods...

}

