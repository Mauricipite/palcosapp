package com.usa.palcoapp.repository.crudrepository;

import com.usa.palcoapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
