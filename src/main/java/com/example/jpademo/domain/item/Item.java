package com.example.jpademo.domain.item;


import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.categoryitem.CategoryItem;
import lombok.ToString;

import javax.persistence.*;


@ToString(of = {"id","name","price","stockQuantity"})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item extends BaseTimeEntity {


    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="item_id")
    private Long id;


    @JoinColumn(name = "categoryItem_id")
    @ManyToOne(fetch = FetchType.EAGER) //역방향
    private CategoryItem categoryItem;

    private String name;
    private Integer price;
    private Integer stockQuantity; //재고수량




}
