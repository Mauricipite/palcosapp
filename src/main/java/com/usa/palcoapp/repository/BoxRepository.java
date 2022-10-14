package com.usa.palcoapp.repository;

import com.usa.palcoapp.model.Box;
import com.usa.palcoapp.repository.crudrepository.BoxCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoxRepository {
    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public List<Box> getAllBoxes(){
        return (List<Box>) boxCrudRepository.findAll();
    }

    public Optional<Box> getBoxById (Integer id){
        return boxCrudRepository.findById(id);
    }

    public Box saveBox(Box box){
        return boxCrudRepository.save(box);
    }

    public void deleteBox(Box box){
        boxCrudRepository.delete(box);
    }
}
