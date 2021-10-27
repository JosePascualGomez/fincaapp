package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Score;

/**
 * Definición de propios de las Calificaciones
 * @author José Pascual Gómez Blanco
 * @serial 25/09/2021
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    /**
     * @apiNote Permite listar todas las calificaciones
     * @return Lista de calificaciones creadas
     */
    public List<Score> getScores(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    /**
     * @apiNote consultar una calificación por id
     * @param idScore identificador de la calificación a consultar
     * @return calificación consultada
     */
    public Optional <Score> getScoreById(Long idScore){
        return scoreCrudRepository.findById(idScore);
    }

    /**
     * @apiNote Permite crear una nueva calificación
     * @param score datos con los que se crea la calificación
     * @return calificación creada
     */
    public Score saveScore (Score score){
        return scoreCrudRepository.save(score);
    }

    /**
     * @apiNote Permite elimiar una calificación por Objeto
     * @param score a calificación a eliminar
     */
    public void deleteScore(Score score){
        scoreCrudRepository.delete(score);
    }

    /**
     * @apiNote Permite elimiar una calificación por Id
     * @param id identificador de la calificación a eliminar
     */
    public void deleteScoreById(Long id){
        scoreCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Permite Eliminar todas las calificaciones
     */
    public void deleteAll(){
        scoreCrudRepository.deleteAll();
    }
}
