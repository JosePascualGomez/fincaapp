package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Client;
import co.edu.usa.fincaapp.servicios.ClientService;

@RestController
@RequestMapping(path = "/api")
public class Api {
    @Autowired
    ClientService clientServicio;

    @RequestMapping(
            method=RequestMethod.GET, 
            path = "/client",
            consumes = "application/json",
            produces = "application/json" )
    public @ResponseBody List<Client> listarClientes(){
        return clientServicio.getClients();
    }

}
