package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Message;

/**
 * Interfaz de persistencia de los mensajes
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public interface MessageCrudRepository extends CrudRepository<Message,Long>{
    
}
