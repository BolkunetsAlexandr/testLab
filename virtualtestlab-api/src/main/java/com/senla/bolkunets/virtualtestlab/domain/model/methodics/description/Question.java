package com.senla.bolkunets.virtualtestlab.domain.model.methodics.description;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONS")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEXT", nullable = false)
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
