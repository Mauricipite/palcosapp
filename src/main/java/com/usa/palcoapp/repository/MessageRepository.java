package com.usa.palcoapp.repository;

import com.usa.palcoapp.model.Message;
import com.usa.palcoapp.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAllMessages(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessageById (Integer id){
        return messageCrudRepository.findById(id);
    }

    public Message saveMessage(Message message){
        return messageCrudRepository.save(message);
    }

    public void deleteMessage(Message message){
        messageCrudRepository.delete(message);
    }
}
