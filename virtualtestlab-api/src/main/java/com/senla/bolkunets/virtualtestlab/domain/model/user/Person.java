package com.senla.bolkunets.virtualtestlab.domain.model.user;


import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;

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

    @OneToOne(mappedBy = "person")
    private UserProfile userProfile;

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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<PassingFact> getPassingFacts() {
        return passingFacts;
    }

    public void setPassingFacts(List<PassingFact> passingFacts) {
        this.passingFacts = passingFacts;
    }
}
