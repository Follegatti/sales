package com.follegatti.controller;

import com.follegatti.model.Category;
import com.follegatti.service.CategoryServiceImpl;
import com.follegatti.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @GetMapping
    public List<Category> readAll() throws Exception{
        return service.readAll();
    }
    @GetMapping("/{id}")
    public Category readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }
    @PostMapping
    public Category create(@RequestBody Category category) throws Exception{
        return service.save(category);
    }
    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable Integer id) throws Exception{
        return service.update(category, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
         service.dalate(id);
    }
}
