package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.MessageRepository;
import co.edu.usa.fincaapp.entidades.Message;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessages(){
        return messageRepository.getMessages();
    }

    public Optional<Message> getMessage(Long idMessage){
        return messageRepository.getMessageById(idMessage);
    }

    public Message saveMessage(Message message){
        return messageRepository.saveMessage(message);
    }
    
    public Message updateMessage(Message message){
        if (message != null) {
            if (message.getIdMessage() != null){
                Optional<Message> oMessage = getMessage(message.getIdMessage());
                if (!oMessage.isEmpty()){
                    Message cli = oMessage.get();
                    if (message.getMessageText() !=null){
                        cli.setMessageText(message.getMessageText());
                    }
                    if (message.getFarm() !=null){
                        cli.setFarm(message.getFarm());
                    }              
                    if (message.getClient() !=null){
                        cli.setClient(message.getClient());
                    }              

                    return messageRepository.saveMessage(cli);
                }
            }
        }
        return message;
    }

    public void deleteAll(){
        messageRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Message> oMessage = getMessage(id);
        if (!oMessage.isEmpty()){
            messageRepository.deleteMessage(oMessage.get());                        
        }        
    }
}
