package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.ScoreRepository;
import co.edu.usa.fincaapp.entidades.Score;

@Service
public class ScoreService {
    @Autowired
    public
    ScoreRepository scoreRepository;

    public List<Score> getScores(){
        return scoreRepository.getScores();
    }

    public  Optional<Score> getScore(Long id){
        return scoreRepository.getScoreById(id);
    }

    public Score saveScore(Score Score){
        return scoreRepository.saveScore(Score);
    }
    
    public Score updateScore(Score score){
        if (score != null) {
            if (score.getId() != null){
                Optional<Score> oScore = getScore(score.getId());
                if (!oScore.isEmpty()){
                    Score sco = oScore.get();
                    if (score.getScore() !=null){
                        sco.setScore(score.getScore());
                    }
                    if (score.getMessage() !=null){
                        sco.setMessage(score.getMessage());
                    }
                    if (score.getReservation() !=null){
                        sco.setReservation(score.getReservation());
                    }
                    return scoreRepository.saveScore(sco);
                }
            }
        }
        return score;
    }
    

    public void deleteAll(){
        scoreRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Score> oScore = getScore(id);
        if (!oScore.isEmpty()){
            scoreRepository.deleteScore(oScore.get());                        
        }        
    }
}