package com.usa.palcoapp.controladores;

import com.usa.palcoapp.model.Box;
import com.usa.palcoapp.servicio.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class boxController {
    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAllBoxes(){
        return boxService.getAllBoxes();
    }

    @GetMapping("/{idBox}")
    public Optional<Box> getBoxById (@PathVariable("idBox") Integer id){
        return boxService.getBox(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody Box box){
        return boxService.saveBox(box);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update(@RequestBody Box box){
        return boxService.updateBox(box);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return boxService.deleteBox(id);
    }


}
