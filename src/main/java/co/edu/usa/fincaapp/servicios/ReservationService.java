package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.ReservationRepository;
import co.edu.usa.fincaapp.entidades.Reservation;

@Service
public class ReservationService {
    @Autowired
    public
    ReservationRepository reservationRepository;

    public List<Reservation> getReservations(){
        return reservationRepository.getReservations();
    }

    public Optional<Reservation> getReservation(Long id){
        return reservationRepository.getReservationById(id);
    }

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.saveReservation(reservation);
    }
    
    public Reservation updateReservation(Reservation reservation){
        if (reservation != null) {
            if (reservation.getIdReservation() != null){
                Optional<Reservation> oReservation = getReservation(reservation.getIdReservation());
                if (!oReservation.isEmpty()){
                    Reservation res = oReservation.get();
                    if (reservation.getStartDate() !=null){
                        res.setStartDate(reservation.getStartDate());
                    }
                    if (reservation.getDevolutionDate() !=null){
                        res.setDevolutionDate(reservation.getDevolutionDate());
                    }
                    if (reservation.getStatus() !=null){
                        res.setStatus(reservation.getStatus());
                    }

                    if (reservation.getFarm() !=null){
                        res.setFarm(reservation.getFarm());
                    }              
                    if (reservation.getClient() !=null){
                        res.setClient(reservation.getClient());
                    }   
                    if (reservation.getScore() !=null){
                        res.setScore(reservation.getScore());
                    }            

                    return reservationRepository.saveReservation(res);
                }
            }
        }
        return reservation;
    }
    
    public void deleteAll(){
        reservationRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Reservation> oReservation = getReservation(id);
        if (!oReservation.isEmpty()){
            reservationRepository.deleteReservation(oReservation.get());                        
        }        
    }
}
