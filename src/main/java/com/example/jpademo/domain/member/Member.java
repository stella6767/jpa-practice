package com.example.jpademo.domain.member;


import com.example.jpademo.domain.locker.Locker;
import com.example.jpademo.domain.memberproduct.MemberProduct;
import com.example.jpademo.domain.order.Order;
import com.example.jpademo.domain.product.Product;
import com.example.jpademo.domain.team.Team;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@ToString(of = {"id","username","age"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Member { //주 테이블

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="member_id")
    private Long id;

    private String username;

    private Integer age;

    /**
     * 일대다 양방향 VS 다대일 양방향
     * 둘은 사실 같은 말이지만, 왼쪽을 연관관계의 주인으로 치고 구분한다면
     * 항상 다대일 양방향 맵핑을 하자. (예외는 있을 수 있음)
     * @param username
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id") //외래키의 주인! joinCoulumn을 안 쓰면, JPA는 연결테이블을 중간에 두고 연관관계를
    private Team team; //관리하는 조인 테이블 전략을 기본으로 사용



    /**
     * 일대일 관계에서는 어느 쪽이든 외래키를 가질 수 있다.
     * 따라서 누가 외래키를 가질지 선택해야 한다.
     * 주 테이블에 외래키 = 객체지향개발자 선호
     * 대상 테이블에 외래키 = DBA 가 선호, 테이블 관계를 일대다로 변경할떄, 테이블 구조를 그대로 유지가능
     */

    @OneToOne //주 테이블의 자기 필드명
    @JoinColumn(name = "locker_id") //연관관계의 주인
    private Locker locker;


    /**
     * 관계형 db에서는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없다.
     * 그래서 연결 테이블을 사용. @ManyToMany를 사용하면 간단하게 연결테이블을 만들 수 있지만
     * 연결테이블에 필요한 칼럼을 추가할 수 없기 때문에 실무에서 사용하기는 한계점이 있음
     */
//    @ManyToMany
//    @JoinTable(name = "member_product",
//    joinColumns = @JoinColumn(name = "member_id"),
//    inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products = new ArrayList<>();

    
//    @OneToMany(mappedBy = "member") //역방향
//    private List<MemberProduct> memberProducts;


    /**
     * 식별관계: 받아온 식별자를 기본 키 + 외래 키로 사용
     * 비식별 관계: 받아온 식별자는 외래키로만 사용하고, 새로운 식별자를 추가. (추천)
      */

    @OneToMany(mappedBy = "member") //역방향
    private List<Order> orders;

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
