package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface NewsRepository extends JpaRepository<NewEntity,Long> {
    @Query("SELECT u FROM NewEntity u WHERE u.id = :id ")
    NewEntity findNewEntity(@Param("id") Long id);


}
