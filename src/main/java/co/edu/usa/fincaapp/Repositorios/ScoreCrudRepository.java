package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Score;

/**
 * Interfaz de persistencia de las calificaciones
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public interface ScoreCrudRepository extends CrudRepository<Score, Long>{
    
}
