package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Category;
/**
 * Definición de propios de las categorias
 * @author José Pascual Gómez Blanco
 * @serial 15/09/2021
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    /**
     * 
     * @return Listado de Categorias
     */
    public List<Category> getCategories(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    /**
     * @apiNote Retorna una categoría
     * @param idCategory id de la categoría que se quiere consultar
     * @return categoria consultada
     */
    public Optional <Category> getCategoryById(Long idCategory){
        return categoryCrudRepository.findById(idCategory);
    }

    /**
     * @apiNote Permite crear una nueva categoría
     * @param category categoría que se creará
     * @return La categoría creada
     */
    public Category saveCategory (Category category){
        return categoryCrudRepository.save(category);
    }

    /**
     * @apiNote Permite eliminar una categoría por categoría
     * @param category caegoría a eliminar
     */
    public void deleteCategory(Category category){
        categoryCrudRepository.delete(category);
    }

    /**
     * @apiNote Permite eliminar una categoría por Id
     * @param id Número que identifica la categoria
     */
    public void deleteCategoryById(Long id){
        categoryCrudRepository.deleteById(id);
    }

    /**
     * @apiNote Permite eliminar la totalidad de las categorías
     */
    public void deleteAll(){
        categoryCrudRepository.deleteAll();
    }
}
