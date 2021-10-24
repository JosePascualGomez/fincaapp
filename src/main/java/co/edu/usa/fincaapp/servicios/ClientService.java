package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.ClientRepository;
import co.edu.usa.fincaapp.entidades.Client;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clienteRepository;

    public List<Client> getClients(){
        return clienteRepository.getClients();
    }

    public Optional<Client> getClient(Long id){
        return clienteRepository.getClientById(id);
    }

    public Client saveClient(Client client){
        if (client != null) {
            if (client.getIdClient() != null){
                Optional<Client> oClient = getClient(client.getIdClient());
                if (oClient.isEmpty()){
                    return clienteRepository.saveClient(client);
                }else{
                    return client;
                }
            }else{
                return clienteRepository.saveClient(client);
            }
        }
        return null;
    }

    public Client updateCliente(Client client){
        if (client != null) {
            if (client.getIdClient() != null){
                Optional<Client> oClient = getClient(client.getIdClient());
                if (!oClient.isEmpty()){
                    Client cli = oClient.get();
                    if (client.getName() !=null){
                        cli.setName(client.getName());
                    }
                    if (client.getEmail() !=null){
                        cli.setEmail(client.getEmail());
                    }
                    if(client.getAge()!=null){
                        cli.setAge(client.getAge());
                    }
                    if(client.getPassword()!=null){
                        cli.setPassword(client.getPassword());
                    }
                    if(client.getMessages()!=null){
                        cli.setMessages(client.getMessages());
                    }
                    if(client.getReservations()!=null){
                        cli.setReservations(client.getReservations());
                    }
                    return clienteRepository.saveClient(cli);
                }
            }
        }
        return client;
    }

    public boolean deleteLamda(Long id){
        Boolean seBorro = getClient(id).map(client ->{
            clienteRepository.deleteClient(client);
            return true;
        }).orElse(false);
        return seBorro;
    }

    public void delete(Long id){
        Optional<Client> oClient = getClient(id);
        if (!oClient.isEmpty()){
            clienteRepository.deleteClient(oClient.get());                        
        }        
    }

    public void deleteAll(){
        clienteRepository.deleteAll();
    }
}
