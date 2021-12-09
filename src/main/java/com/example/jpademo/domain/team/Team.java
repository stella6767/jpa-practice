package com.example.jpademo.domain.team;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    private String motto; //팀의 사훈

}
