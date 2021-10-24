package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Score;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getScores(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional <Score> getScoreById(Long idScore){
        return scoreCrudRepository.findById(idScore);
    }

    public Score saveScore (Score Score){
        return scoreCrudRepository.save(Score);
    }

    public void deleteScore(Score Score){
        scoreCrudRepository.delete(Score);
    }

    public void deleteScoreById(Long id){
        scoreCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        scoreCrudRepository.deleteAll();
    }
}
