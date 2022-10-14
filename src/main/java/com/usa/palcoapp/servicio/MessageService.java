package com.usa.palcoapp.servicio;

import com.usa.palcoapp.model.Message;
import com.usa.palcoapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages(){
        return messageRepository.getAllMessages();
    }

    public Optional<Message> getMessage(Integer id) {return messageRepository.getMessageById(id);}

    public Message saveMessage (Message message){
        if (message.getIdMessage() == null){
            return messageRepository.saveMessage(message);
        } else {
            Optional<Message> optional = messageRepository.getMessageById(message.getIdMessage());
            if (optional.isEmpty()) {
                return messageRepository.saveMessage(message);
            } else {
                return message;
            }
        }
    }

    public Message updateMessage (Message message){
        if (message.getIdMessage() != null){
            Optional<Message> optional = messageRepository.getMessageById(message.getIdMessage());
            if (!optional.isEmpty()) {
                if (message.getMessageText() != null) {
                    optional.get().setMessageText(message.getMessageText());
                    optional.get().setClient(message.getClient());
                    optional.get().setBox(message.getBox());
                }
                messageRepository.saveMessage(optional.get());
                return optional.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage (Integer id){
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.deleteMessage(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
