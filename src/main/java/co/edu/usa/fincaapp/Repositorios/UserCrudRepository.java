package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.User;

/**
 * Interfaz de persistencia de los Usuarios
 * @author José Pascual Gómez Blanco
 * @serial 24/09/2021
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    
}
