package co.edu.usa.fincaapp.dto;

import co.edu.usa.fincaapp.entidades.Client;

/**
 * Objeto que permite generar la salida del servicio Reservation/report-clients
 * @author José Pascual Gómez Blanco
 * @serial 26/10/2021
 */
public interface ClientTotalResInter {
    Long getTotal();
    
    Client getClient();
}
