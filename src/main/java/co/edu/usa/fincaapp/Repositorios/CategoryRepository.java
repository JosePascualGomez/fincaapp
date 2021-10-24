package co.edu.usa.fincaapp.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Category;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getCategories(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional <Category> getCategoryById(Long idCategory){
        return categoryCrudRepository.findById(idCategory);
    }

    public Category saveCategory (Category category){
        return categoryCrudRepository.save(category);
    }

    public void deleteCategory(Category category){
        categoryCrudRepository.delete(category);
    }

    public void deleteCategoryById(Long id){
        categoryCrudRepository.deleteById(id);
    }

    public void deleteAll(){
        categoryCrudRepository.deleteAll();
    }
}
