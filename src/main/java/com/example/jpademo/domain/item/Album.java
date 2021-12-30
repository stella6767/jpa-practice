package com.example.jpademo.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ToString
@Getter @Setter
@Entity
@DiscriminatorValue("A")
public class Album extends Item{


    private String artist;
    private String etc;


}
