package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Category;

/**
 * Interfaz de persistencia de las categorias
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public interface CategoryCrudRepository  extends CrudRepository<Category, Long>{
    
}
