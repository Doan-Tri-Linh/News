package com.laptrinhjavaweb.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity  extends BaseEntity{

    @Column(name ="code")
    private  String code;

    @Column
    private  String name;

    @OneToMany(mappedBy = "category")
    private List<NewEntity> news = new ArrayList<>();



}
