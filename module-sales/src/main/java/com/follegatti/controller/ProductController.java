package com.follegatti.controller;

import com.follegatti.dto.ProductDTO;
import com.follegatti.model.Product;
import com.follegatti.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;
    @Qualifier("productMapper")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<ProductDTO>>  readAll() throws Exception{
       // ModelMapper mapper = new ModelMapper();
        List<ProductDTO> list = service.readAll().stream().map(e ->convertToDto(e)).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Product obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) throws Exception{
        Product obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO dto, @PathVariable Integer id) throws Exception{
        Product obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.dalate(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ProductDTO convertToDto(Product obj){
        return mapper.map(obj, ProductDTO.class);
    }
    private Product convertToEntity(ProductDTO dto){
        return mapper.map(dto, Product.class);
    }
}
