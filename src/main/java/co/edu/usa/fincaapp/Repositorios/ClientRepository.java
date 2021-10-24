package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Client;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getClients(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional <Client> getClientById(Long idCliente){
        return clientCrudRepository.findById(idCliente);
    }

    public Client saveClient (Client cliente){
        return clientCrudRepository.save(cliente);
    }

    public void deleteClient(Client cliente){
        clientCrudRepository.delete(cliente);
    }

    public void deleteClientByID(Long id){
        clientCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        clientCrudRepository.deleteAll();
    }
}
