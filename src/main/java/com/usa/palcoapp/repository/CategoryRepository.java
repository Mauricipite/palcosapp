package com.usa.palcoapp.repository;

import com.usa.palcoapp.model.Category;
import com.usa.palcoapp.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAllCategories(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategoryById (Integer id){
        return categoryCrudRepository.findById(id);
    }

    public Category saveCategory(Category category){
        return categoryCrudRepository.save(category);
    }

    public void deleteCategory(Category category){
        categoryCrudRepository.delete(category);
    }

}
