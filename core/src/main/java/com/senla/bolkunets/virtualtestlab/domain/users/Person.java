package com.senla.bolkunets.virtualtestlab.domain.users;


import com.senla.bolkunets.virtualtestlab.domain.methodics.result.PassingFact;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PEOPLE")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Organization organization;

    @Column(name = "AGE")
    private Integer integer;

    @Column(name = "MARITAL_STATUS")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "COUNT_CHILDREN")
    private Integer countChildren;

    @Column(name = "PLACE_RESIDENCE")
    @Enumerated(EnumType.STRING)
    private PlaceResidence placeResidence;

    @OneToMany(mappedBy = "person")
    private List<PassingFact> passingFacts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(Integer countChildren) {
        this.countChildren = countChildren;
    }

    public PlaceResidence getPlaceResidence() {
        return placeResidence;
    }

    public void setPlaceResidence(PlaceResidence placeResidence) {
        this.placeResidence = placeResidence;
    }
}
