package com.senla.bolkunets.virtualtestlab.controllers.dto;

import com.senla.bolkunets.virtualtestlab.domain.model.users.Gender;
import com.senla.bolkunets.virtualtestlab.domain.model.users.MaritalStatus;
import com.senla.bolkunets.virtualtestlab.domain.model.users.PlaceResidence;

public class PersonDto {

    private Integer id;

    private Gender gender;

    private Integer integer;

    private MaritalStatus maritalStatus;

    private Integer countChildren;

    private PlaceResidence placeResidence;

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
}
