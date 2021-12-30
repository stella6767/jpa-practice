package com.example.jpademo.repository.category;

import com.example.jpademo.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
