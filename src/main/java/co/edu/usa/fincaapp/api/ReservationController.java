package co.edu.usa.fincaapp.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.usa.fincaapp.dto.ClientTotalRes;
import co.edu.usa.fincaapp.dto.ClientTotalResInter;
import co.edu.usa.fincaapp.entidades.Reservation;
import co.edu.usa.fincaapp.servicios.ReservationService;

/**
 * @apiNote Expone los servicios de las Reservaciones
 * @author José Pascual Gómez Blanco
 * @serial 24/10/2021
 */
@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    /**
     * @apiNote Permite listar todas las reservaciones
     * @return Lista de fincas reservaciones
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }

    /**
     * @apiNote Permite crear una nueva reservación
     * @param Reservation datos con los que se crea la reservación
     * @return reservación creada
     */    
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation){
        Reservation reservationSave = reservationService.saveReservation(reservation);
        return reservationSave;
    }

    /**
     * @apiNote Permite actualizar una reservación por objeto
     * @param reservation Objeto reservación a eliminar
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        Reservation reservationSave = reservationService.updateReservation(reservation);
        return reservationSave;
    }

    /**
     * @apiNote Eliminar todas las reservaciones
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllReservation(){
        reservationService.deleteAll();
    }

    /**
     * @apiNote Permite elimiar una reservación por Id
     * @param id identificador de la reservación a eliminar
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        reservationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @apiNote Permite elimiar una reservación por Id
     * @param id identificador de la reservación a eliminar
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        reservationService.delete(id);        
    }

    /**
     * @apiNote listar las reservaciones entre dos fechas
     * @param first Fecha inical para filtrar la reservación
     * @param finish Fecha final para filtrar la reservación
     * @return Listado de reservaciones que cumplen con el filtro
     */
    @GetMapping(value="/report-dates/{first}/{finish}")
    public List<Reservation> findAllByStartDateBetween(@PathVariable("first") @DateTimeFormat(pattern = "yyyy-MM-dd") Date  first, 
                                                    @PathVariable("finish") @DateTimeFormat(pattern = "yyyy-MM-dd") Date finish){
        return reservationService.findAllByStartDateBetween(first, finish);        
    }

    /**
     * 
     * @return Retorna las reservaciones completadas y las canceladas
     */
    @GetMapping(value="/report-status")
    public Object getCountStatus(){
        return reservationService.getCountStatus();
    }

    /**
     * 
     * @return Reorna el total de reservacioens por cliente y la info del mismo
     */
    @GetMapping("/report-clients")
    public List<ClientTotalRes> countByClient(){
        return reservationService.countByClient();
    }

    /**
     * 
     * @return Retorna el total de reservaciones por cliente y la info del mismo, usando interfaz coomo DTO
     */
    @GetMapping("/report-clients-Int")
    public List<ClientTotalResInter> countByClientInters(){
        return reservationService.countByClientInters();
    }
}
