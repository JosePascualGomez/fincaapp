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

/**
 * @apiNote Expone los servicios de Usuarios
 * @author José Pascual Gómez Blanco
 * @serial 24/10/2021
 */
@RestController
@RequestMapping("api/User")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     * @apiNote Permite listar todos los Usuarios 
     * @return Listado de Usuarios
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * @apiNote Permite crear un Usuario
     * @param user datos para crear el nuevo Usuario
     * @return Usuario creado
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        User userSave = userService.saveUser(user);
        return userSave;
    }

    /**
     * @apiNote Permite actualizar un Usuario existente
     * @param user datos con los que se actualiza el Usuario
     * @return Usuario actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        User userSave = userService.updateUser(user);
        return userSave;
    }

    /**
     * @apiNote Permite actualizar un Usuario existente
     * @param user datos con los que se actualiza el Usuario
     * @return Usuario actualizado
     */
    @PutMapping("/update1")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public User update1User(@RequestBody User user){
        User userSave = userService.saveUser(user);
        return userSave;
    }

    /**
     * @apiNote Permite eliminar todos los Usuarios
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllUser(){
        userService.deleteAll();
    }
    
    /**
     * @apiNote Permite eliminar un Usuario
     * @param id Indentificador del Usuario e eliminar
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @apiNote Permite eliminar un Usuario
     * @param id Indentificador del Usuario e eliminar
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        userService.delete(id);        
    }
}
