package com.senla.bolkunets.virtualtestlab.domain.model.methodics.result;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.users.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PASSING_FACT")
public class PassingFact {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date passingDate;

    @ManyToOne
    @JoinColumn(name = "PEOPLE_ID", nullable = false)
    private Person person;

    @Column(name = "METHODICS_ID", nullable = false)
    private Integer methodicsId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCALE_VALUE_ID")
    private List<ScaleValue> scaleValues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPassingDate() {
        return passingDate;
    }

    public void setPassingDate(Date passingDate) {
        this.passingDate = passingDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getMethodicsId() {
        return methodicsId;
    }

    public void setMethodicsId(Integer methodicsId) {
        this.methodicsId = methodicsId;
    }

    public List<ScaleValue> getScaleValues() {
        return scaleValues;
    }

    public void setScaleValues(List<ScaleValue> scaleValues) {
        this.scaleValues = scaleValues;
    }
}
