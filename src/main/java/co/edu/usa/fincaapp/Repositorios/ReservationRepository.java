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

    /**
     * Permite listar las reservaciones entre dos fechas
     * @param first
     * @param finish
     * @return
     */
    public List<Reservation> findBystartDateBetween(Date first, Date finish){
        return reservationCrudRepository.findBystartDateBetween(first, finish);
    }

    /**
     * 
     * @return Reorna el total de reservacioens por cliente y la info del mismo
     */
    public List<ClientTotalRes> CountByClient(){
        return reservationCrudRepository.CountByClient();
    }

    /**
     * 
     * @return Reorna el total de reservacioens por cliente y la info del mismo, usando interfazcoomo DTO
     */
    public List<ClientTotalResInter> countByClientInters(){
        return reservationCrudRepository.CountByClientInter();
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
