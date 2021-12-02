package com.api.system.registration.Service;

import com.api.system.registration.Entity.Animal;
import com.api.system.registration.Repository.AnimalRepository;
import com.api.system.registration.Service.Interface.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository ) {
        this.animalRepository = animalRepository;
    }


    @Override
    public List<Animal> findAll() {
        return this.animalRepository.findAll();
    }

    @Override
    public Animal findById(Integer sequenceId) {
        return this.animalRepository.findById(sequenceId).get();
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepository.save(animal);
    }

    @Override
    public void deleteById(Integer sequenceId) {
        this.animalRepository.deleteById(sequenceId);
    }

    @Override
    public void update(Animal animal, Integer sequenceId) {
        this.animalRepository.save(animal);
    }
}
