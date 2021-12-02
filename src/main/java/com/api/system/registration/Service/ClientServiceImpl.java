package com.api.system.registration.Service;

import com.api.system.registration.Entity.Client;
import com.api.system.registration.Repository.ClientRepository;
import com.api.system.registration.Service.Interface.ClientService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final EntityManager entityManager;

    public ClientServiceImpl(EntityManager entityManager, ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client findByNameSurname(String nameSurname) {
        CriteriaBuilder ca = entityManager.getCriteriaBuilder();
        //Donus icin
        CriteriaQuery<Client> cq = ca.createQuery(Client.class);
        //sql-from
        Root<Client> root = cq.from(Client.class);
        //where RoomBookng.sumSprice = 10
        Predicate searchField = ca.like(root.get("nameSurname"), "%" + nameSurname + "%");
        cq.where(ca.and(searchField));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Transactional
    @Override
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public void deleteById(Integer sequenceId) {
        this.clientRepository.deleteById(sequenceId);
    }


    @Override
    public void update(Client client, Integer sequenceId) {
        this.clientRepository.save(client);
    }
}
