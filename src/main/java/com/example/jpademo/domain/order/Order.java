package com.example.jpademo.domain.order;


import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.delivery.Delivery;
import com.example.jpademo.domain.member.Member;
import com.example.jpademo.domain.orderitem.OrderItem;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * lazy loading이면 조회할 엔티티에 따라 jpql fetch join을 따로 사용해야한다.
 * 엔티티 그래프 기능을 사용하면, 엔티티를 조회하는 시점에서 함께 조회할 연관엔티티를 선택할 수 있다.
 * 따라서 jpql은 데이터를 조회하는 기능만 수행하면 되고, 연관된 엔티티를 함께 수행하는 기능은 엔티티 
 * 그래프를 사용하면 된다. subgraphs를 활용하면,연관관계 엔티티가 참조하는 엔티티까지 함께 조회가능
 */



@ToString(of = {"id","status","orderDate", "orderAmount"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(name = "Order.withMember", attributeNodes = {
        @NamedAttributeNode("member")
})
@Getter @Setter
@Entity
@Table(name = "ORDERS")
public class Order extends BaseTimeEntity {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="order_id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;//MemberProductId.member와 연결

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id") 
    private Delivery delivery; //order가 외래키의 주인

    @CreationTimestamp
    private Timestamp orderDate;

    private Integer orderAmount;


    public void setMember(Member member){ //lombok setter 오버로딩

        if(this.member != null){
            this.member.getOrders().add(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }


    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    public void setDelivery(Delivery delivery){ //lombok setter 오버로딩

        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
