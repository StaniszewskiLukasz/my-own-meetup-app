package com.example.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Base64;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")//tutaj to jest rednundancja bo hybernate standardowo zrobi kolumny o takiej nazwie
    private String firstName;   //czyli camelCase zamienia na snakeCase

    @Column(name = "last_name")
    private String lastName;

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
}
