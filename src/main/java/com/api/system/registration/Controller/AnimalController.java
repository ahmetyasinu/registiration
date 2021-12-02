package com.api.system.registration.Controller;

import com.api.system.registration.Entity.Animal;
import com.api.system.registration.Service.Interface.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     * Tum hayvanlarin listesini elde etmek icin kullanilir.
     * @return kayitli tum hayvanlar.
     */
    @RequestMapping(path = "/animalList", method = RequestMethod.POST, produces = "application/json")
    public List<Animal> findAll() {
        return this.animalService.findAll();
    }

    /**
     * Animals tablosuna yeni bir hayvan eklemek icin kullanilir.
     * @param animal eklenecek hayvanin ozelliklerini iceren obje formati.
     * @return kaydedilen hayvan.
     */
    @RequestMapping(path = "/save", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public Animal animal(@RequestBody  Animal animal) {
        return this.animalService.save(animal);
    }

    /**
     * Herhangi bir hayvanin bilgilerini elde etmek icin kullanilir
     * @param sequenceId hayvan sira numarasi
     * @return id numarasi verilen hayvan bilgilerinin obje formati.
     */
    @RequestMapping(path = "/getAnimal", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public Animal animal(@RequestBody int sequenceId) {
        Animal animal = animalService.findById(sequenceId);
        if (animal == null) {
            throw new RuntimeException("id bulunamadı" + sequenceId);
        }
        return animal;
    }

    /**
     * Animals tablosundan bir hayvan silmek icin kullanilir.
     * @param sequenceId silinmesi istenen hayvanin sira numarasi.
     */
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE,
            consumes = "application/json", produces = "application/json")
    public void deleteSequenceId(@RequestBody int sequenceId) {
        animalService.deleteById(sequenceId);
    }

}
