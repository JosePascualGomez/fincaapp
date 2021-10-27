package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.User;

/**
 * Definición de propios de los Usuarios
 * @author José Pascual Gómez Blanco
 * @serial 15/10/2021
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * @apiNote Permite listar todos los Usuarios 
     * @return Listado de Usuarios
     */
    public List<User> getUsers(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * @apiNote consultar un usuario
     * @param idUser identificador del usuario a consultar
     * @return usuario cnosultado
     */
    public Optional <User> getUserById(Long idUser){
        return userCrudRepository.findById(idUser);
    }

    /**
     * @apiNote Permite crear un Usuario
     * @param user datos para crear el nuevo Usuario
     * @return Usuario creado
     */
    public User saveUser (User user){
        return userCrudRepository.save(user);
    }

    /**
     * @apiNote Eliminar un usuario por objeto
     * @param user usuario a eliminar
     */
    public void deleteUser(User user){
        userCrudRepository.delete(user);
    }

    /**
     * @apiNote Permite eliminar un Usuario
     * @param id Indentificador del Usuario e eliminar
     */
    public void deleteUserById(Long id){
        userCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Permite eliminar todos los Usuarios
     */
    public void deleteAll(){
        userCrudRepository.deleteAll();
    } 

}
