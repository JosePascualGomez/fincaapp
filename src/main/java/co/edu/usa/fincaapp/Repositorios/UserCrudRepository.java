package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    
}
