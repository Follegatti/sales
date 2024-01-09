package com.follegatti.service.impl;

import com.follegatti.model.Client;
import com.follegatti.repo.ICategoryRepo;
import com.follegatti.repo.IClientRepo;
import com.follegatti.repo.IGenericRepo;
import com.follegatti.service.ICRUD;
import com.follegatti.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService {
    private IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }
}
