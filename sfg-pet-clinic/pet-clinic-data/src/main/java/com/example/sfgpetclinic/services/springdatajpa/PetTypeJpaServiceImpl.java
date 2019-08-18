package com.example.sfgpetclinic.services.springdatajpa;

import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import com.example.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType type) {
        return petTypeRepository.save(type);
    }

    @Override
    public void delete(PetType type) {
petTypeRepository.delete(type);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
