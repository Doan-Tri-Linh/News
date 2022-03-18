package com.laptrinhjavaweb.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class NewEntity extends BaseEntity{
    @Column
    private String title;

    @Column
    private String thumbnail;

    @Column
    private String shortdescription;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}

