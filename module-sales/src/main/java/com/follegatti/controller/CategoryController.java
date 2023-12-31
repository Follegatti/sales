package com.follegatti.controller;

import com.follegatti.model.Category;
import com.follegatti.service.CategoryServiceImpl;
import com.follegatti.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @GetMapping
    public ResponseEntity<List<Category>>  readAll() throws Exception{
        List<Category> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> readById(@PathVariable("id") Integer id) throws Exception{
        Category obj = service.readById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) throws Exception{
        Category obj = service.save(category);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Integer id) throws Exception{
        Category obj = service.update(category, id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.dalate(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
