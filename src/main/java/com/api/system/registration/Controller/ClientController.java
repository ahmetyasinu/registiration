package com.api.system.registration.Controller;

import com.api.system.registration.Entity.Client;
import com.api.system.registration.Service.Interface.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Musteri listesini elde etmek icin kullanilir.
     * @return Client tablosundaki tum musteriler.
     */
    @RequestMapping(path = "/clientList", method = RequestMethod.POST, produces = "application/json")
    public List<Client> findAll() {
        return this.clientService.findAll();
    }

    /**
     * Yeni bir musteri kaydetmek icin kullanilir.
     * @param client kaydedilecek musterinin bilgilerini iceren obje formati.
     * @return bilgileri kaydedilen musterinin obje formati.
     */
    @RequestMapping(path = "/save", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public Client client(@RequestBody  Client client) {
        return this.clientService.save(client);
    }

    /**
     *
     * @param sequenceId
     * @return
     */
    @RequestMapping(path = "/get", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public Client client(@RequestBody String nameSurname) {
        Client client = clientService.findByNameSurname(nameSurname);
        if (client == null) {
            throw new RuntimeException("Şu kişi bulunamadı: " + nameSurname);
        }
        return client;
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public void deleteSequenceId(@RequestBody int sequenceId) {
        clientService.deleteById(sequenceId);
    }
}
