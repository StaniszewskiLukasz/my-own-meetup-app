package com.example.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)//załaduję wszystkie zależności
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id")
            ,inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Specialty> specialities) {
        this.specialities = specialities;
    }
}
