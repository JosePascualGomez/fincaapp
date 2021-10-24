package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Farm;

@Repository
public class FarmRepository {
    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farm> getFarms(){
        return (List<Farm>) farmCrudRepository.findAll();
    }

    public Optional <Farm> getFarmById(Long idFarm){
        return farmCrudRepository.findById(idFarm);
    }

    public Farm saveFarm (Farm farm){
        return farmCrudRepository.save(farm);
    }

    public void deleteFarm(Farm farm){
        farmCrudRepository.delete(farm);
    }

    public void deleteFarmById(Long id){
        farmCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        farmCrudRepository.deleteAll();
    }
}
