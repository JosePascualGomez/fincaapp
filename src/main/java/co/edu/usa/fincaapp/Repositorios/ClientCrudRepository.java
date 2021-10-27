package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Client;

/**
 * Interfaz de persistencia de los Clientes
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Long>{
    
}
