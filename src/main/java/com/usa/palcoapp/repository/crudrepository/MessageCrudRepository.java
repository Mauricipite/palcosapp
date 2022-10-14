package com.usa.palcoapp.repository.crudrepository;

import com.usa.palcoapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
