package co.edu.usa.fincaapp.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Reservation;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation,Long> {
    
}
