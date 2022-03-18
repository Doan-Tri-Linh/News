package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class NewService implements INewService<NewEntity> {
   @Autowired
   private NewsRepository newsRepository;

   @Autowired
    private CategoryRepository  categoryRepository;

   @Autowired
    private NewConverter newConverter;

   @Autowired
   private ModelMapper modelMapper;

    @Override
    public NewDTO save(NewDTO newDTO) {

        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() != null){
            NewEntity oldNewEntity = newsRepository.findNewEntity(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO,oldNewEntity);
        }
        else{
                newEntity = newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newsRepository.save(newEntity);
        return newConverter.toNewDTO(newEntity);
    }

    @Override
    public NewDTO GetNewDTO(Long id) {
        NewEntity entity = newsRepository.findNewEntity(id);
        return newConverter.toNewDTO(entity);
    }

    @Override
    public void deletNew(Long id) {
         newsRepository.deleteById(id);
    }

    @Override
    public void deleteManyNews(long[] ids) {
        for( long item : ids){
            newsRepository.deleteById(item);
        }
        }

    @Override
    public List<NewDTO> getManyNews() {
        List<NewEntity> listEntity = new ArrayList<>();
        List<NewDTO> listDTO = new ArrayList<>();
        listEntity = newsRepository.findAll();
        for( NewEntity item : listEntity ){
            listDTO.add(newConverter.toNewDTO(item));
        }
        return listDTO ;
    }

}



