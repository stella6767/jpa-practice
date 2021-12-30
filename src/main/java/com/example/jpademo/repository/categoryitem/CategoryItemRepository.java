package com.example.jpademo.repository.categoryitem;

import com.example.jpademo.domain.categoryitem.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long> {
}
