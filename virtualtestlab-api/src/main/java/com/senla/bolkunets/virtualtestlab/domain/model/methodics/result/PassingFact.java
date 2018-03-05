package com.senla.bolkunets.virtualtestlab.domain.model.methodics.result;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PASSING_FACT")
public class PassingFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date passingDate;

    @ManyToOne
    @JoinColumn(name = "PEOPLE_ID", nullable = false)
    private Person person;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCALE_VALUE_ID")
    private List<ScaleValue> scaleValues;

    @ManyToOne
    @JoinColumn(name = "METHODICS_ID")
    private Methodics methodics;

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

    public List<ScaleValue> getScaleValues() {
        return scaleValues;
    }

    public void setScaleValues(List<ScaleValue> scaleValues) {
        this.scaleValues = scaleValues;
    }

    public Methodics getMethodics() {
        return methodics;
    }

    public void setMethodics(Methodics methodics) {
        this.methodics = methodics;
    }
}
