package com.usa.palcoapp.servicio;

import com.usa.palcoapp.model.Box;
import com.usa.palcoapp.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes() {
        return boxRepository.getAllBoxes();
    }

    public Optional<Box> getBox(Integer id) {
        return boxRepository.getBoxById(id);
    }

    public Box saveBox(Box box) {
        if (box.getId() == null) {
            return boxRepository.saveBox(box);
        } else {
            Optional<Box> optional = boxRepository.getBoxById(box.getId());
            if (optional.isEmpty()) {
                return boxRepository.saveBox(box);
            } else {
                return box;
            }
        }
    }

    public Box updateBox (Box box) {
        if (box.getId() != null) {
            Optional<Box> optional = boxRepository.getBoxById(box.getId());
            if (!optional.isEmpty()) {
                if (box.getName() != null) {
                    optional.get().setName(box.getName());
                }
                if (box.getCapacity() != null) {
                    optional.get().setCapacity(box.getCapacity());
                }
                if (box.getLocation() != null) {
                    optional.get().setLocation(box.getLocation());
                }
                if (box.getDescription() != null) {
                    optional.get().setDescription(box.getDescription());
                }
                if (box.getCategory() != null) {
                    optional.get().setCategory(box.getCategory());
                }
                boxRepository.saveBox(optional.get());
                return optional.get();
            } else {
                return box;
            }
        } else {
            return box;
        }
    }

    public boolean deleteBox (Integer id){
        Boolean aBoolean=getBox(id).map(box -> {
            boxRepository.deleteBox(box);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}