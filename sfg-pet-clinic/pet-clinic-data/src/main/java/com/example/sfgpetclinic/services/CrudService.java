package com.example.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import java.util.Set;

public interface CrudService<T, ID> {
    //wcześniej nie było CrudService i kazdy z interfejsów ownera peta i veta miały te meody co poniżej
    //teraz w CrudService mamy te metody generyczne a tylko owner ma jedną metodę specjalistyczną swoją

    Set <T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void  deleteById(ID id);

}
