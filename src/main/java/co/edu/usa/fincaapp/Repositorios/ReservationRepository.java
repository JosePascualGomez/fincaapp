package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Reservation;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getReservations(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional <Reservation> getReservationById(Long idReservation){
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservation saveReservation (Reservation Reservation){
        return reservationCrudRepository.save(Reservation);
    }

    public void deleteReservation(Reservation Reservation){
        reservationCrudRepository.delete(Reservation);
    }

    public void deleteReservationById(Long id){
        reservationCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        reservationCrudRepository.deleteAll();
    }
}
