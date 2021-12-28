package com.example.jpademo.domain.team;


import com.example.jpademo.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@ToString(of = {"id","name"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Team {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") //1:N 관계에서는 1이 외래키의 주인이 아니므로, mappedBy로 외래키의 주인이 아니라는 걸 알림!
    private List<Member> members = new ArrayList<>(); //주인이 아닌 쪽이므로, 읽기만 할 수 있다.

    public Team(String name) {
        this.name = name;
    }

    public void addMember(Member member){
        this.members.add(member);
    //양쪽에 다 작성하면 둘 중 하나만 호출하면 된다.
        if(member.getTeam() != this){//무한루프에 빠지는지 체크
            member.setTeam(this);
        }
    }

}
