package co.edu.usa.fincaapp.Repositorios;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.dto.ClientTotalRes;
import co.edu.usa.fincaapp.dto.ClientTotalResInter;
import co.edu.usa.fincaapp.entidades.Reservation;

/**
 * Definición de propios de las Reservaciones
 * @author José Pascual Gómez Blanco
 * @serial 25/09/2021
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    /**
     * @apiNote Permite listar todas las reservaciones
     * @return Lista de fincas reservaciones
     */
    public List<Reservation> getReservations(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    /**
     * @apiNote Retorna una reserva
     * @param idReservation identificador de una reseva
     * @return reserva consultada
     */
    public Optional <Reservation> getReservationById(Long idReservation){
        return reservationCrudRepository.findById(idReservation);
    }

    /**
     * @apiNote Permite crear una nueva reservación
     * @param reservation datos con los que se crea la reservación
     * @return reservación creada
     */ 
    public Reservation saveReservation (Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    /**
     * @apiNote Permite elimiar una reservación por Objeto
     * @param reservation identificador de la reservación a eliminar
     */
    public void deleteReservation(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    /**
     * @apiNote Permite elimiar una reservación por Id
     * @param id identificador de la reservación a eliminar
     */
    public void deleteReservationById(Long id){
        reservationCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Eliminar todas las reservaciones
     */
    public void deleteAll(){
        reservationCrudRepository.deleteAll();
    }

    /**
     * @apiNote listar las reservaciones entre dos fechas
     * @param first Fecha inical para filtrar la reservación
     * @param finish Fecha final para filtrar la reservación
     * @return Listado de reservaciones que cumplen con el filtro
     */
    public List<Reservation> findAllByStartDateBetween(Date first, Date finish){
        return reservationCrudRepository.findAllByStartDateBetween(first, finish);
    }

    /**
     * 
     * @return Reorna el total de reservacioens por cliente y la info del mismo
     */
    public List<ClientTotalRes> countByClient(){
        return reservationCrudRepository.countByClient();
    }

    /**
     * 
     * @return Retorna el total de reservaciones por cliente y la info del mismo, usando interfaz coomo DTO
     */
    public List<ClientTotalResInter> countByClientInters(){
        return reservationCrudRepository.countByClientInter();
    }
    
    /**
     * 
     * @return Retorna el total de reservaciones por cliente y la info del mismo, usando Object
     */
    public List<Object[]> countReservationtByClient(){
        return reservationCrudRepository.countReservationtByClient();
    }

    /**
     * 
     * @return Retorna las reservaciones completadas y las canceladas
     */
    public Object getCountStatus(){
        Long completadas = reservationCrudRepository.countByStatus("completed");
        Long canceladas = reservationCrudRepository.countByStatus("cancelled");

        Map <String , Long> salida = new LinkedHashMap<String , Long>();
        salida.put("completed",completadas);
        salida.put("cancelled", canceladas);        
        
        return salida;
    }
        
}
