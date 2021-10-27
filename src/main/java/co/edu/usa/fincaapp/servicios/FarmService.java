package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.FarmRepository;
import co.edu.usa.fincaapp.entidades.Farm;

/**
 * @apiNote Expone los servicios que dan acceso a los métodos del crud
 * @author José Pascual Gómez Blanco
 * @serial 21/10/2021
 * @version 1.0
 */
@Service
public class FarmService {
    @Autowired
    FarmRepository farmRepository;

    public List<Farm> getFarms(){
        return farmRepository.getFarms();
    }

    public Optional<Farm> getFarm(Long id){
        return farmRepository.getFarmById(id);
    }

    public Farm saveFarm(Farm farm){
        return farmRepository.saveFarm(farm);
    }

    public Farm updateFarm(Farm farm){
        if (farm != null) {
            if (farm.getId() != null){
                Optional<Farm> oFarm = getFarm(farm.getId());
                if (!oFarm.isEmpty()){
                    Farm far = oFarm.get();
                    if (farm.getName() !=null){
                        far.setName(farm.getName());
                    }
                    if (farm.getAddress() !=null){
                        far.setAddress(farm.getAddress());
                    }
                    if(farm.getExtension()!=null){
                        far.setExtension(farm.getExtension());
                    }
                    if(farm.getDescription()!=null){
                        far.setDescription(farm.getDescription());
                    }
                    if(farm.getCategory()!=null){
                        far.setCategory(farm.getCategory());
                    }
                    if(farm.getMessages()!=null){
                        far.setMessages(farm.getMessages());
                    }
                    if(farm.getReservations()!=null){
                        far.setReservations(farm.getReservations());
                    }

                    return farmRepository.saveFarm(far);
                }
            }
        }
        return farm;
    }
    
    public void deleteAll(){
        farmRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Farm> oFarm = getFarm(id);
        if (!oFarm.isEmpty()){
            farmRepository.deleteFarm(oFarm.get());                        
        }        
    }


}
