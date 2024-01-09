package com.follegatti.repo;

import com.follegatti.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICategoryRepo extends IGenericRepo<Category, Integer> {
   // Category save(Category category);
}
