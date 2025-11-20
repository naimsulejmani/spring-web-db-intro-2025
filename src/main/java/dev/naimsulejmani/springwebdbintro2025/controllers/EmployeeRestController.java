package dev.naimsulejmani.springwebdbintro2025.controllers;

//EmployeeApiController

import dev.naimsulejmani.springwebdbintro2025.models.Employee;
import dev.naimsulejmani.springwebdbintro2025.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/employes")
public class EmployeeRestController {

    //inject employeeRepository
    // ne te ardhmen e zevendesojme me
    // private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        //SELECT * FROM employees;
        return employeeRepository.findAll();
    }

    //http://cacttus.educations/v1/api/employees/1 -> Vildane Kelmendi ,....
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        // SELECT * FROM employees WHERE id = 1;
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        //save ->
        /*
            nese nuk ekziston resource e ruan ate -> INSERT INTO employees (name, surname) VALUES ('', 'Kelmendi');
            nese ekziton resource e ruan ate si update -> UPDATE employees SET name='', surname='' WHERE id=1;
         */
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        //UPDATE employees SET name='', surname='' WHERE id=1;
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }





}
