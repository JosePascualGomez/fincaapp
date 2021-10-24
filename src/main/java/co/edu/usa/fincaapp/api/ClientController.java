package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import co.edu.usa.fincaapp.entidades.Client;
import co.edu.usa.fincaapp.servicios.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client){
        Client clientSave = clientService.saveClient(client);
        return clientSave;
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client updateUser(@RequestBody Client cliente){
        Client clientSave = clientService.updateCliente(cliente);
        return clientSave;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllClient(){
        clientService.deleteAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        clientService.delete(id);        
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        clientService.delete(id);        
    }
}
