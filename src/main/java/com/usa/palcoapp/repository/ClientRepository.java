package com.usa.palcoapp.repository;

import com.usa.palcoapp.model.Client;
import com.usa.palcoapp.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAllClients(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClientById (Integer id){
        return clientCrudRepository.findById(id);
    }

    public Client saveClient(Client client){
        return clientCrudRepository.save(client);
    }

    public void deleteClient(Client client){
        clientCrudRepository.delete(client);
    }
}
