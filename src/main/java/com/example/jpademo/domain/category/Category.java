package com.example.jpademo.domain.category;


import com.example.jpademo.domain.BaseTimeEntity;
import com.example.jpademo.domain.categoryitem.CategoryItem;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@ToString(of = {"id","name"}) //연관관계 필드는 제외한다. 무한루프에 빠지지 않도록
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Category extends BaseTimeEntity {

    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
    @Column(name="category_id")
    private Long id;

    private String name;

    /**
     * 관계형 db에서는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없다.
     * 그래서 연결 테이블을 사용. @ManyToMany를 사용하면 간단하게 연결테이블을 만들 수 있지만
     * 연결테이블에 필요한 칼럼을 추가할 수 없기 때문에 실무에서 사용하기는 한계점이 있음
     * 그래서 Category와 item의 다대다 관계를 연결짓는 CategoryItem 엔티티 생성
     */

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY) //역방향
    private List<CategoryItem> categoryItems = new ArrayList<>();

    //카테고리의 계층 구조를 위한 필드들
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> child = new ArrayList<>();


}
