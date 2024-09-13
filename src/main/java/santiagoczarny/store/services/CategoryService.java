package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Category;
import santiagoczarny.store.entities.Status;
import santiagoczarny.store.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }

    public void deactivate(Category category) {
        category.setStatus(Status.INACTIVE);
        save(category);
    }

}
