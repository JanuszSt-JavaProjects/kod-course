package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")

public class Employee {

    private int id;
    private String firstname;
    private String lastname;

    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE_joinedResultTable",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID_Pierwsze", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID_dowolna_Nazwa", referencedColumnName = "COMPANY_ID")}
    )


    @ManyToMany(cascade = CascadeType.ALL)
    public List<Company> getCompanies() {
        return companies;
    }

    List<Company> companies = new ArrayList<>();


    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }
}