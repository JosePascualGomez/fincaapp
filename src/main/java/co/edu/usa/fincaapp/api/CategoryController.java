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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Category;
import co.edu.usa.fincaapp.servicios.CategoryService;

/**
 * @apiNote Expone los servicios propios de las categorias
 * @author José Pascual Gómez Blanco
 * @serial 24/10/2021
 */
@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategorys(){
        return categoryService.getCategories();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){
        Category categorySave = categoryService.saveCategory(category);
        return categorySave;
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category category){
        Category categorySave = categoryService.updateCategory(category);
        return categorySave;
    }

    @PutMapping("/update1")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Category update1Category(@RequestBody Category category){
        Category categorySave = categoryService.saveCategory(category);
        return categorySave;
    }

    @RequestMapping(value={"/update2"},method=RequestMethod.PUT) @ResponseStatus(HttpStatus.NO_CONTENT) 
    @ResponseBody 
    public Category updatecategory2(@RequestBody Category category){
        Category categorySave = categoryService.saveCategory(category);
        return categorySave;        
    }

    @RequestMapping(value={"/update3"},method=RequestMethod.PUT) @ResponseStatus(HttpStatus.NO_CONTENT) 
    @ResponseBody 
    public Category updatecategory3(@RequestBody Category category){
        Category categorySave = categoryService.saveCategory(category);
        return categorySave;        
    }

    @DeleteMapping("deleteAll")
    public void deleteAllCategory(){
        categoryService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePost(@PathVariable Long id) {
        categoryService.delete(id);        
    }
    
    @DeleteMapping(value = "/deleter/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) {
        categoryService.delete(id);        
    }

    

}
