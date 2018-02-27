package com.senla.bolkunets.virtualtestlab.domain.model.userprofile;

import com.senla.bolkunets.virtualtestlab.domain.model.users.Person;

import javax.persistence.*;

@Entity
@Table(name = "PROFILES_USER")
public class UserProfile {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleUser roleUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
