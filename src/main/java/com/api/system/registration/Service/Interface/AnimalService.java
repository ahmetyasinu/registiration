package com.api.system.registration.Service.Interface;

import com.api.system.registration.Entity.Animal;
import com.api.system.registration.Entity.Client;
import com.api.system.registration.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnimalService {
    List<Animal> findAll();

    Animal findById(Integer sequenceId);

    Animal save(Animal animal);

    void deleteById(Integer sequenceId);

    void update(Animal animal, Integer sequenceId);
}
