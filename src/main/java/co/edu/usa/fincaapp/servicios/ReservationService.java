package co.edu.usa.fincaapp.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.ReservationRepository;
import co.edu.usa.fincaapp.dto.ClientTotalRes;
import co.edu.usa.fincaapp.dto.ClientTotalResInter;
import co.edu.usa.fincaapp.entidades.Reservation;

/**
 * @apiNote Expone los servicios que dan acceso a los métodos del crud
 * @author José Pascual Gómez Blanco
 * @serial 21/10/2021
 * @version 1.0
 */
@Service
public class ReservationService {
    
    /**
     * Interface que permite el crud
     */
    @Autowired
    public
    ReservationRepository reservaRepository;

    /**
     * Listar el total de reservaciones
     * @return listado de reservaciones
     */
    public List<Reservation> getReservations(){
        return reservaRepository.getReservations();
    }

    /**
     * Permite conseguir una reservación
     * @param idReservation
     * @return La reservación buscada por Id
     */
    public Optional<Reservation> getReservation(Long idReservation){
        return reservaRepository.getReservationById(idReservation);
    }

    /**
     * Permite crear una reservación
     * @param reservation
     * @return La reservación creada
     */
    public Reservation saveReservation(Reservation reservation){
        return reservaRepository.saveReservation(reservation);
    }
    
    /**
     * Permite actualizar una reservación
     * @param reservation 
     * @return La reservación actualizada
     */
    public Reservation updateReservation(Reservation reservation){
        if (reservation != null) {
            if (reservation.getIdReservation() != null){
                Optional<Reservation> oReservation = getReservation(reservation.getIdReservation());
                if (!oReservation.isEmpty()){
                    Reservation reserva = oReservation.get();
                    if (reservation.getStartDate() !=null){
                        reserva.setStartDate(reservation.getStartDate());
                    }
                    if (reservation.getDevolutionDate() !=null){
                        reserva.setDevolutionDate(reservation.getDevolutionDate());
                    }
                    if (reservation.getStatus() !=null){
                        reserva.setStatus(reservation.getStatus());
                    }

                    if (reservation.getFarm() !=null){
                        reserva.setFarm(reservation.getFarm());
                    }              
                    if (reservation.getClient() !=null){
                        reserva.setClient(reservation.getClient());
                    }   
                    if (reservation.getScore() !=null){
                        reserva.setScore(reservation.getScore());
                    }            

                    return reservaRepository.saveReservation(reserva);
                }
            }
        }
        return reservation;
    }
    
    /**
     * Permite eliminar todas las reservaciones
     */
    public void deleteAll(){
        reservaRepository.deleteAll();
    }

    /**
     * Permite eliminar una reservación 
     * @param idReservation
     */
    public void delete(Long idReservation){
        Optional<Reservation> oReservation = getReservation(idReservation);
        if (!oReservation.isEmpty()){
            reservaRepository.deleteReservation(oReservation.get());                        
        }        
    }

    /**
     * Permite listar las reservaciones entre dos fechas
     * @param first Fecha inicial
     * @param finish Fecha Final
     * @return Listado de Reservaciones
     */
    public List<Reservation> findAllByStartDateBetween(Date first, Date finish){
        return reservaRepository.findAllByStartDateBetween(first, finish);
    }

    /**
     * 
     * @return Retorna la cantidad reservaciones completadas y canceladas
     */
    public Object getCountStatus(){
        return reservaRepository.getCountStatus();
    }

    /**
     * 
     * @return Retorna un listado de clientes y total reservas
     */
    public List<ClientTotalRes> countByClient(){
        return reservaRepository.countByClient();
    }

    /**
     * 
     * @return Retorna un listado de clientes y total reservas, usando interfaz como DTO
     */
    public List<ClientTotalResInter> countByClientInters(){
        return reservaRepository.countByClientInters();
    }
}
