package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
@RequestMapping
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return   newService.save(model);
    }

    @PutMapping(value ="/new/{newID}")
    public NewDTO updateNew(@RequestBody NewDTO model,@PathVariable(name="newID") long newID){
        model.setId(newID);
        return newService.save(model);
    }

    @GetMapping(value="/new/{newID}")
    public NewDTO getNew( NewDTO model, @PathVariable(name="newID") long newID){
        model = newService.GetNewDTO(newID);
        return  model  ;
    }

    @DeleteMapping(value ="/new/{newID}")
    public void deleteNew(@PathVariable(name="newID") long newId){
       newService.deletNew(newId);
    }
    @DeleteMapping(value = "/new")
    public void deleteManyNew(@RequestBody long[] ids) {
        newService.deleteManyNews(ids);
    }


   @GetMapping(value = "/new")
   public List<NewDTO> getNewsList(){
       return  newService.getManyNews();
   }



}
