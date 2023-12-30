package com.follegatti.repo;

import com.follegatti.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {
   // Category save(Category category);
}
