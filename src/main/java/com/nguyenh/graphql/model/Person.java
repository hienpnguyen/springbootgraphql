package com.nguyenh.graphql.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

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

    public long getPersonId() {
        return id;
    }

    public void setPersonId(long personId) {
        this.id = personId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddressId(Address address) {
        this.address = address;
    }
}