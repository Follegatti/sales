package com.follegatti.service;

import com.follegatti.model.Category;

import java.util.List;

public interface ICategoryService {
    Category save(Category category) throws Exception;
    Category update(Category category, Integer id) throws  Exception;
    List<Category> readAll() throws Exception;
    Category readById(Integer id) throws Exception;
    void dalate(Integer id) throws Exception;
   // Category validAndSave(Category category);
}
