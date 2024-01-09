package com.follegatti.controller;

import com.follegatti.dto.CategoryDTO;
import com.follegatti.model.Category;
import com.follegatti.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService service;
    @Qualifier("categoryMapper")
    private final ModelMapper mapper;
    @GetMapping()
    public ResponseEntity<List<CategoryDTO>>  readAll() throws Exception{
       // ModelMapper mapper = new ModelMapper();
        List<CategoryDTO> list = service.readAll().stream().map(e ->convertToDto(e)).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Category obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO dto) throws Exception{
        Category obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO dto, @PathVariable Integer id) throws Exception{
        Category obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.dalate(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CategoryDTO convertToDto(Category obj){
        return mapper.map(obj, CategoryDTO.class);
    }
    private Category convertToEntity(CategoryDTO dto){
        return mapper.map(dto, Category.class);
    }
}
