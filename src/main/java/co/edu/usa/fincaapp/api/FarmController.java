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

import co.edu.usa.fincaapp.entidades.Farm;
import co.edu.usa.fincaapp.servicios.FarmService;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    public List<Farm> getFarms(){
        return farmService.getFarms();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Farm saveFarm(@RequestBody Farm farm){
        Farm farmSave = farmService.saveFarm(farm);
        return farmSave;
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Farm updateFarm(@RequestBody Farm farm){
        Farm farmSave = farmService.updateFarm(farm);
        return farmSave;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllFarm(){
        farmService.deleteAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        farmService.delete(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        farmService.delete(id);        
    }
}


