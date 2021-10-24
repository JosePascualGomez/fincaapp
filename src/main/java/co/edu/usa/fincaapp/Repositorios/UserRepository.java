package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.User;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getUsers(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional <User> getUserById(Long idUser){
        return userCrudRepository.findById(idUser);
    }

    public User saveUser (User user){
        return userCrudRepository.save(user);
    }

    public void deleteUser(User user){
        userCrudRepository.delete(user);
    }

    public void deleteUserById(Long id){
        userCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        userCrudRepository.deleteAll();
    } 

}
