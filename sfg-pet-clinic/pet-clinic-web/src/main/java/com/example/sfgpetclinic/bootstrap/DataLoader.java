package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

//    public DataLoader() {//wersja bez adnotacj @Service w klasach ownerService i VetService
//        ownerService=new OwnerServiceMap();
//        vetService=new VetServiceMap();
//    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Lukas");
        owner1.setLastName("Bond");
        owner1.setAddress("Wileńska 22");
        owner1.setCity("Lódź");
        owner1.setTelephone("535020850");
        ownerService.save(owner1);

        Pet petOfLukas = new Pet();
        petOfLukas.setPetType(savedDogPetType);
        petOfLukas.setOwner(owner1);
        petOfLukas.setBirthDate(LocalDate.now());
        petOfLukas.setName("Fox");
        owner1.getPets().add(petOfLukas);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marcin");
        owner2.setLastName("Głuś");
        owner2.setAddress("Wileńska 22");
        owner2.setCity("Lódź");
        owner2.setTelephone("654879632");
        System.out.println("Loaded Owners...");

        Pet petOfMarcin = new Pet();
        petOfMarcin.setPetType(savedCatPetType);
        petOfMarcin.setOwner(owner2);
        petOfMarcin.setBirthDate(LocalDate.now());
        petOfMarcin.setName("Kiciuś");
        owner2.getPets().add(petOfMarcin);

        ownerService.save(owner2);//ta metoda nadaje id ownerowi ale takze petowi!!!

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("claw remove");
        visit.setPet(petOfMarcin);
        visitService.save(visit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Tomek");
        vet1.setLastName("Kruk");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marek");
        vet2.setLastName("Bobek");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}
