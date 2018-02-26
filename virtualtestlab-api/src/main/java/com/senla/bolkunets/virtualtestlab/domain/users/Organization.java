package com.senla.bolkunets.virtualtestlab.domain.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORGANISATIONS")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String organisationName;

    @Column(name = "NUMBER_EMPLS")
    private Integer numberEmployees;

    @OneToMany
    private List<Person> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
