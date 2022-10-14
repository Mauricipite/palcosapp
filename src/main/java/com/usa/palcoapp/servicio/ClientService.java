package com.usa.palcoapp.servicio;

import com.usa.palcoapp.model.Category;
import com.usa.palcoapp.model.Client;
import com.usa.palcoapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }

    public Optional<Client> getClient(Integer id) {return clientRepository.getClientById(id);}

    public Client saveClient (Client client){
        if (client.getIdClient() == null){
            return clientRepository.saveClient(client);
        } else {
            Optional<Client> optional = clientRepository.getClientById(client.getIdClient());
            if (optional.isEmpty()) {
                return clientRepository.saveClient(client);
            } else {
                return client;
            }
        }
    }

    public Client updateClient (Client client){
        if (client.getIdClient() != null){
            Optional<Client> optional = clientRepository.getClientById(client.getIdClient());
            if (!optional.isEmpty()) {
                if (client.getName() != null) {
                    optional.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    optional.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    optional.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    optional.get().setAge(client.getAge());
                }
                clientRepository.saveClient(optional.get());
                return optional.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient (Integer id){
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.deleteClient(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
