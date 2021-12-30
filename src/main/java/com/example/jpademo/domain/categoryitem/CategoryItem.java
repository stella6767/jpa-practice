package com.example.jpademo.domain.categoryitem;

import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.category.Category;
import com.example.jpademo.domain.item.Item;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@ToString(of = {"id"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class CategoryItem extends BaseTimeEntity {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="categoryitem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "categoryItem" , fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();


}
