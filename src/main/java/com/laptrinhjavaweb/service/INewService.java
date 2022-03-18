package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

import java.util.List;


public interface INewService<T> {
    NewDTO save(NewDTO newDTO);
    NewDTO GetNewDTO(Long id);
    void deletNew(Long id);

    void deleteManyNews(long[] id);
    List<NewDTO> getManyNews();

}
