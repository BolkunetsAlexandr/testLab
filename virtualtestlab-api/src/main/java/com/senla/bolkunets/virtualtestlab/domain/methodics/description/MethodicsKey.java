package com.senla.bolkunets.virtualtestlab.domain.methodics.description;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "METHODICS_KEYS")
public class MethodicsKey {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SCALE_NAME")
    private String nameScale;

    @OneToMany
    @JoinColumn(name = "KEY_ID")
    private List<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameScale() {
        return nameScale;
    }

    public void setNameScale(String nameScale) {
        this.nameScale = nameScale;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
