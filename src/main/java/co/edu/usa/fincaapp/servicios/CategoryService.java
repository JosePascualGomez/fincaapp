package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.Repositorios.CategoryRepository;
import co.edu.usa.fincaapp.entidades.Category;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.getCategories();
    }

    public Optional<Category> getCategory(Long id){
        return categoryRepository.getCategoryById(id);
    }

    public Category saveCategory(Category category){
        return categoryRepository.saveCategory(category);
    }

    public Category updateCategory(Category category){
        if (category != null) {
            if (category.getId() != null){
                Optional<Category> oCategory = getCategory(category.getId());
                if (!oCategory.isEmpty()){
                    Category cli = oCategory.get();
                    if (category.getName() !=null){
                        cli.setName(category.getName());
                    }
                    if (category.getDescription() !=null){
                        cli.setDescription(category.getDescription());
                    }                    
                    return categoryRepository.saveCategory(cli);
                }
            }
        }
        return category;
    }

    public void deleteAll(){
        categoryRepository.deleteAll();
    }

    public void delete(Long id){
        Optional<Category> oCategory = getCategory(id);
        if (!oCategory.isEmpty()){
            categoryRepository.deleteCategory(oCategory.get());                        
        }        
    }
    
}
