package com.follegatti.service.impl;

import com.follegatti.model.Category;
import com.follegatti.repo.ICategoryRepo;
import com.follegatti.repo.IGenericRepo;
import com.follegatti.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {
    @Autowired
    private ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }
/*
    @Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    @Override
    public Category update(Category category, Integer id) throws Exception {
        category.setIdCategory(id);
        return repo.save(category);
    }

    @Override
    public List<Category> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Category());
    }

    @Override
    public void dalate(Integer id) throws Exception {
        repo.deleteById(id);
    }*/
}
