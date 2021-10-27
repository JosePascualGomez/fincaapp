package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Farm;

/**
 * Definición de propios de las Fincas
 * @author José Pascual Gómez Blanco
 * @serial 25/09/2021
 */
@Repository
public class FarmRepository {
    @Autowired
    private FarmCrudRepository farmCrudRepository;

    /**
     * @apiNote Permite listar todas las fincas
     * @return Lista de fincas creadas
     */
    public List<Farm> getFarms(){
        return (List<Farm>) farmCrudRepository.findAll();
    }

    /**
     * @apiNote Permite consultar una finca
     * @param idFarm identificador de la finca a consultar
     * @return finca consultada
     */
    public Optional <Farm> getFarmById(Long idFarm){
        return farmCrudRepository.findById(idFarm);
    }
    
    /**
     * @apiNote Permite crear una nueva finca
     * @param farm datos con los que se crea la finca
     * @return finca creada
     */    
    public Farm saveFarm (Farm farm){
        return farmCrudRepository.save(farm);
    }

    /**
     * @apiNote Permite eliminar una finca por objeto
     * @param farm Objeto finca a eliminar
     */
    public void deleteFarm(Farm farm){
        farmCrudRepository.delete(farm);
    }

    /**
     * @apiNote Permite elimiar una finca por Id
     * @param id identificador de la finca a eliminar
     */
    public void deleteFarmById(Long id){
        farmCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Permite Eliminar todas las fincas
     */
    public void deleteAll(){
        farmCrudRepository.deleteAll();
    }
}
