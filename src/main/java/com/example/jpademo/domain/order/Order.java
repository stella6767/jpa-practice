package com.example.jpademo.domain.order;


import com.example.jpademo.domain.member.Member;
import com.example.jpademo.domain.product.Product;

import javax.persistence.*;

@Entity
public class Order {

    /**
     *  다대다 새로운 기본 키 사용
     */


    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="order_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;//MemberProductId.member와 연결

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; //MemberProductId.product와 연결

    private Integer orderAmount;

}
