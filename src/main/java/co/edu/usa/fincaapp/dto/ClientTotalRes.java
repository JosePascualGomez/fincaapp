package co.edu.usa.fincaapp.dto;

import co.edu.usa.fincaapp.entidades.Client;

/**
 * Objeto que permite generar la salida del servicio Reservation/report-clients
 */
public class ClientTotalRes{
    
    long total;
    Client client;


    public ClientTotalRes(){

    }

    public ClientTotalRes(Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

       
}
