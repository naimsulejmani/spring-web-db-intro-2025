package dev.naimsulejmani.springwebdbintro2025.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String phone;

    @Column(length = 150, nullable = false)
    private String address;
    @Column(length = 50, nullable = false)
    private String city;
    @Column(length = 50, nullable = false)
    private String state;
    @Column(length = 10, nullable = false)
    private String zipCode;//=> zip_code
    @Column(length = 50, nullable = false)
    private String country;
    @Column(length = 50, nullable = false)
    private String department;
    @Column(length = 100, nullable = false)
    private String position;
    @Column(name = "salary")
    private float salary;

    @Column(nullable = false)
    private LocalDate startDate;


    private LocalDate endDate;

    private boolean passive = false;
    @Column(length = 1000)
    private String notes;

    private String photo;

}
