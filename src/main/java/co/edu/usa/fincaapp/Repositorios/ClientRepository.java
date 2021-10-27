package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Client;

/**
 * Definición de propios de los clientes
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    /**
     * @apiNote Permite listar todos los clientes 
     * @return Listado de clientes
     */
    public List<Client> getClients(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    /**
     * @apiNote Permite consultar un cliente
     * @param idCliente idenificador del cliente a consultar
     * @return cliente consultado
     */
    public Optional <Client> getClientById(Long idCliente){
        return clientCrudRepository.findById(idCliente);
    }

    /**
     * @apiNote Permite crear un cliente
     * @param cliente datos para crear el nuevo cliente
     * @return Cliente creado
     */
    public Client saveClient (Client cliente){
        return clientCrudRepository.save(cliente);
    }

    /**
     * @apiNote Permite eliminar un cliente por objeto
     * @param cliente Cliente e eliminar
     */
    public void deleteClient(Client cliente){
        clientCrudRepository.delete(cliente);
    }

    /**
     * @apiNote Permite eliminar un cliente
     * @param id Indentificador del cliente e eliminar
     */
    public void deleteClientByID(Long id){
        clientCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Permite eliminar todos los clientes
     */
    public void deleteAll(){
        clientCrudRepository.deleteAll();
    }
}
