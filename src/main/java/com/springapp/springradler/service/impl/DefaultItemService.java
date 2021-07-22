package com.springapp.springradler.service.impl;

import com.springapp.springradler.service.ItemService;
import com.springapp.springradler.service.domain.CreateItemRequest;
import com.springapp.springradler.service.domain.Item;
import com.springapp.springradler.service.domain.UpdateItemRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultItemService implements ItemService {

    private final ProductItemRepository repository;
    private final ProductItemMapper mapper;

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return mapper.map(repository.findAll(pageable));
    }

    @Override
    public Item getOne(Long id) {
        return mapper.map(repository.getOne(id));
    }

    @Override
    public Item create(CreateItemRequest createItemRequest) {
        return mapper.map(repository.save(mapper.map(createItemRequest)));
    }

    @Override
    public Item update(Long id, UpdateItemRequest updateItemRequest) {
        final var item = repository.getOne(id);
        mapper.map(item, updateItemRequest);
        return mapper.map(repository.save(item));
    }

    @Override
    public void delete(Long id) {
        final var item = repository.getOne(id);
        repository.delete(item);
    }

}
