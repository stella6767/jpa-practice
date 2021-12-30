package com.example.jpademo.domain.orderitem;


import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.item.Item;
import com.example.jpademo.domain.order.Order;
import lombok.*;

import javax.persistence.*;



@ToString(of = {"id","item","orderPrice", "count"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class OrderItem extends BaseTimeEntity {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="orderItem_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer orderPrice; //주문 가격
    private Integer count; //주문 수량


}
