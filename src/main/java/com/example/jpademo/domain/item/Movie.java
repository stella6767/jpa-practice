package com.example.jpademo.domain.item;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ToString
@Getter @Setter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;
    private String actor;


}
