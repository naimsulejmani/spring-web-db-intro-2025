package dev.naimsulejmani.springwebdbintro2025.repositories;

import dev.naimsulejmani.springwebdbintro2025.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //gjej te gjithe puntoret qe punojne ne departametmint e dhene SELECT * FROM employees where department='IT'
    List<Employee> findAllByDepartment(String department);
    //gjej te gjithe puntoret sipas pozites
    List<Employee> findAllByPosition(String position);
    //gjej te gjithe puntoret qe emri i tyre e permban
    List<Employee> findAllByNameContaining(String name);

    List<Employee> findAllByDepartmentAndPosition(String department, String position);
    //SELECT * FROM employees where department=? and position=?
    List<Employee> findAllByDepartmentOrPosition(String department, String position);
    //SELECT * FROM employees where department=? or position=?

    long countByDepartment(String department); // SELECT COUNT(*) FROM employees where department='IT'

    List<Employee> findAllBySalaryGreaterThanOrderByStartDate(float salary); // SELECT * FROM employees where salary>? ORDER BY startDate

    Employee findOneByEmail(String email);// SELECT * FROM employees where email=?

    Optional<Employee> findOneByPhone(String phone); // SELECT * FROM employees where phone=?

    List<Employee> findAllBySalaryBetweenOrderBySalaryDesc(float minSalary, float maxSalary);
    //SELECT * FROM employees where salary BETWEEN ? AND ? ORDER BY salary DESC

    //not passive employee
    List<Employee> findAllByPassiveIsFalse();
}
