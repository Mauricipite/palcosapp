package com.usa.palcoapp.repository.crudrepository;

import com.usa.palcoapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
