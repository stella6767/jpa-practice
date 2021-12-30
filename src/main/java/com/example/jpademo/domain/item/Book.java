package com.example.jpademo.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@ToString
@Getter
@Setter
@Entity
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;

}
