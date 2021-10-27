package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Message;

/**
 * Definición de propios de los mensajes
 * @author José Pascual Gómez Blanco
 * @serial 05/10/2021
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     * @apiNote Permite listar todos los mensajes
     * @return Lista de mensajes creados
     */
    public List<Message> getMessages(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    /**
     * @apiNote Consultar un mensaje por id
     * @param idMessage idenificador del mensaje a consultar
     * @return mensaje consultado
     */
    public Optional <Message> getMessageById(Long idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    /**
     * @apiNote Permite crear un mensaje
     * @param message datos para crear el nuevo mensaje
     * @return mensajes creado
     */
    public Message saveMessage(Message message){
        return messageCrudRepository.save(message);
    }

    /**
     * @apiNote Permite eliminar un mensaje por objeto
     * @param message mensaje a eliminar
     */
    public void deleteMessage(Message message){
        messageCrudRepository.delete(message);
    }

    /**
     * @apiNote Permite eliminar un mensaje
     * @param idMessage Identificador del mensaje a eliminar
     */
    public void deleteMessageById(Long idMessage){
        messageCrudRepository.deleteById(idMessage);
    }

    /**
     * @apiNote Permite eliminar todos los mensajes
     */
    public void deleteAll(){
        messageCrudRepository.deleteAll();
    }
}
