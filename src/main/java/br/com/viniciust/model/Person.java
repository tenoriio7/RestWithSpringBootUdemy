package br.com.viniciust.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hibernate gera o id
    private  Long id;

    @Column(name = "first_name",nullable = false)
    private  String firstName;

    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @Column(name = "gender", nullable = false)
    private  String gender;

    @Column(name = "address", nullable = false)
    private String  address;

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender);
    }


}
