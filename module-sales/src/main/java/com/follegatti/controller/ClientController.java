package com.follegatti.controller;

import com.follegatti.dto.ClientDTO;
import com.follegatti.model.Client;
import com.follegatti.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<ClientDTO>>  readAll() throws Exception{
       // ModelMapper mapper = new ModelMapper();
        List<ClientDTO> list = service.readAll().stream().map(e ->convertToDto(e)).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Client obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto) throws Exception{
        Client obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientDTO dto, @PathVariable Integer id) throws Exception{
        Client obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.dalate(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ClientDTO convertToDto(Client obj){
        return mapper.map(obj, ClientDTO.class);
    }
    private Client convertToEntity(ClientDTO dto){
        return mapper.map(dto, Client.class);
    }
}
