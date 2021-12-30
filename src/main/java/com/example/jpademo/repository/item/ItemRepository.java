package com.example.jpademo.repository.item;

import com.example.jpademo.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
