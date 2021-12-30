package com.example.jpademo.domain.member;


import com.example.jpademo.domain.Address;
import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.order.Order;
import com.example.jpademo.utills.BooleanToYNConverter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Convert(converter = BooleanToYNConverter.class, attributeName = "vip")
@ToString(of = {"id","username","age","address", "vip"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Member extends BaseTimeEntity { //주 테이블

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="member_id")
    private Long id;
    private String username;
    private Integer age;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //역방향
    //@OrderBy("orderAmount desc, id asc") //이건 사용
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address address;

    private boolean vip;

    public void printMember(){
        System.out.println("회원 이름 " + this.getUsername());
    }

    public Member(String username, Integer age, boolean vip) {
        this.username = username;
        this.age = age;
        this.vip = vip;
    }
}

