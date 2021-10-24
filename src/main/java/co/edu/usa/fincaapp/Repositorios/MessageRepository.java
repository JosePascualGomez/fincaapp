package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Message;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getMessages(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional <Message> getMessageById(Long idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    public Message saveMessage(Message message){
        return messageCrudRepository.save(message);
    }

    public void deleteMessage(Message message){
        messageCrudRepository.delete(message);
    }

    public void deleteMessageById(Long idMessage){
        messageCrudRepository.deleteById(idMessage);
    }

    public void deleteAll(){
        messageCrudRepository.deleteAll();
    }
}
