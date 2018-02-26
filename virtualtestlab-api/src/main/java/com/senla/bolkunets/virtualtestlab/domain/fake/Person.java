package com.senla.bolkunets.virtualtestlab.domain.fake;



import javax.persistence.*;

@Entity
@Table(name = "PEOPLE")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;


    @Column(name = "AGE")
    private Integer age;



    @Column(name = "COUNT_CHILDREN")
    private Integer countChildren;

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer integer) {
        this.age = integer;
    }

    public Integer getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(Integer countChildren) {
        this.countChildren = countChildren;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", countChildren=" + countChildren +
                '}';
    }
}
