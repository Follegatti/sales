package com.follegatti.service.impl;

import com.follegatti.model.Product;
import com.follegatti.repo.IProductRepo;
import com.follegatti.repo.IGenericRepo;
import com.follegatti.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {
    private IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return repo;
    }
}
