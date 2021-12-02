package com.api.system.registration.Service.Interface;

import com.api.system.registration.Entity.Animal;
import com.api.system.registration.Entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ClientService {
    List<Client> findAll();

    Client findByNameSurname(String nameSurname);

    Client save(Client client);

    void deleteById(Integer sequenceId);

    void update(Client client, Integer sequenceId);


}
