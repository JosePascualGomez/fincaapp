package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import co.edu.usa.fincaapp.entidades.User;
import co.edu.usa.fincaapp.servicios.UserService;

@RestController
@RequestMapping("api/User")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        User userSave = userService.saveUser(user);
        return userSave;
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        User userSave = userService.updateUser(user);
        return userSave;
    }

    @PutMapping("/update1")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public User update1User(@RequestBody User user){
        User userSave = userService.saveUser(user);
        return userSave;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllUser(){
        userService.deleteAll();
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        userService.delete(id);        
    }
}
