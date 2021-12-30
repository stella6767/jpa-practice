package com.example.jpademo.domain.delivery;


import com.example.jpademo.domain.Address;
import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.order.Order;
import lombok.*;

import javax.persistence.*;




@ToString(of = {"id","address","status"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Delivery extends BaseTimeEntity {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="delivery_id")
    private Long id;


    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


}
