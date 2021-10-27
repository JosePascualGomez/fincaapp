package co.edu.usa.fincaapp.Repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.dto.ClientTotalRes;
import co.edu.usa.fincaapp.dto.ClientTotalResInter;
import co.edu.usa.fincaapp.entidades.Reservation;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation,Long> {
    /**
     * 
     * @param first
     * @param finish
     * @return Listado de reservaciones entre dos fechas
     */   
    List<Reservation> findBystartDateBetween(Date first, Date finish);
    
    /**
     * 
     * @param status
     * @return cantidad con reservaciones filtradas por estado
     */
    long countByStatus(String status);

    /**
     * 
     * @return Listado de clientes y su total de reservaciones
     */
    @Query(value = "SELECT new co.edu.usa.fincaapp.dto.ClientTotalRes(count(idReservation) as total, client) FROM Reservation GROUP BY client ORDER BY 1 desc")
    List<ClientTotalRes> CountByClient();

    /**
     * @return Listado de clientes y su total de reservaciones, usando interfaz com oDTO
     */
    @Query(value = "SELECT count(idReservation) as total, client FROM Reservation GROUP BY client ORDER BY 1")
    List<ClientTotalResInter> CountByClientInter();
}
