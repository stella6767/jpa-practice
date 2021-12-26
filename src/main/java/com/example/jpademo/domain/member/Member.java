package com.example.jpademo.domain.member;


import com.example.jpademo.domain.team.Team;
import lombok.*;

import javax.persistence.*;



@ToString(of = {"id","username","age"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Member {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="member_id")
    private Long id;

    private String username;

    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, Integer age) {
        this(username, age, null);
    }

    public Member(String username, Integer age, Team team){
        this.username = username;
        this.age = age;

        if(team != null){
            changeTeam(team);
        }
    }


    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

}
