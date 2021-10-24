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


import co.edu.usa.fincaapp.entidades.Score;
import co.edu.usa.fincaapp.servicios.ScoreService;

@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getScores(){
        return scoreService.getScores();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score saveScore(@RequestBody Score score){
        Score scoreSave = scoreService.saveScore(score);
        return scoreSave;
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score updateScore(@RequestBody Score score){
        Score scoreSave = scoreService.updateScore(score);
        return scoreSave;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllScore(){
        scoreService.deleteAll();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        scoreService.delete(id);        
    }
}
