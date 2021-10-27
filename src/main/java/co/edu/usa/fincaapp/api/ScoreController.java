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

/**
 * @apiNote Expone los servicios de las calificaciones
 * @author José Pascual Gómez Blanco
 * @serial 25/10/2021
 */
@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * @apiNote Permite listar todas las calificaciones
     * @return Lista de calificaciones creadas
     */
    @GetMapping("/all")
    public List<Score> getScores(){
        return scoreService.getScores();
    }

    /**
     * @apiNote Permite crear una nueva calificación
     * @param score datos con los que se crea la calificación
     * @return calificación creada
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score saveScore(@RequestBody Score score){
        Score scoreSave = scoreService.saveScore(score);
        return scoreSave;
    }

    /**
     * @apiNote Actualiza una calificación existente
     * @param score datos con los cuales se actualiza la calificación
     * @return calificación actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score updateScore(@RequestBody Score score){
        Score scoreSave = scoreService.updateScore(score);
        return scoreSave;
    }
    
    /**
     * @apiNote Permite Eliminar todas las calificaciones
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllScore(){
        scoreService.deleteAll();
    }

    /**
     * @apiNote Permite elimiar una calificación por Id
     * @param id identificador de la calificación a eliminar
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        scoreService.delete(id);        
    }
}
