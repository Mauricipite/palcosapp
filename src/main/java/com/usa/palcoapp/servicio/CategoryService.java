package com.usa.palcoapp.servicio;

import com.usa.palcoapp.model.Category;
import com.usa.palcoapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }

    public Optional<Category> getCategory(Integer id) {return categoryRepository.getCategoryById(id);}

    public Category saveCategory(Category category) {
        if (category.getId() == null){
            return categoryRepository.saveCategory(category);
        } else {
            Optional<Category> optional = categoryRepository.getCategoryById(category.getId());
            if (optional.isEmpty()) {
                return categoryRepository.saveCategory(category);
            } else {
                return category;
            }
        }
    }

    public Category updateCategory (Category category){
        if (category.getId() != null){
            Optional<Category> optional = categoryRepository.getCategoryById(category.getId());
            if (!optional.isEmpty()) {
                if (category.getName() != null) {
                    optional.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    optional.get().setDescription(category.getDescription());
                }
                categoryRepository.saveCategory(optional.get());
                return optional.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean deleteCategory (Integer id){
        Boolean aBoolean = getCategory(id).map(category -> {
            categoryRepository.deleteCategory(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
