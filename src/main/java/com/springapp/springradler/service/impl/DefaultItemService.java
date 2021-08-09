package com.springapp.springradler.service.impl;

import com.springapp.springradler.config.CacheConfiguration;
import com.springapp.springradler.data.repository.ProductItemRepository;
import com.springapp.springradler.service.ItemService;
import com.springapp.springradler.service.domain.CreateItemRequest;
import com.springapp.springradler.service.domain.Item;
import com.springapp.springradler.service.domain.UpdateItemRequest;
import com.springapp.springradler.service.mapper.ProductItemMapper;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultItemService implements ItemService {

    private final ProductItemRepository repository;
    // private final ProductItemMapper mapper;

    ProductItemMapper mapper = ProductItemMapper.INSTANCE;

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return mapper.map(repository.findAll(pageable));
    }

    @Override
    @Cacheable(CacheConfiguration.ITEMS_CACHE)
    public Item getOne(Long id) {
        return mapper.map(repository.getOne(id));
    }

    @Override
    @Transactional
    public Item create(CreateItemRequest createItemRequest) {
        return mapper.map(repository.save(mapper.map(createItemRequest)));
    }

    @Override
    @Transactional
    @CacheEvict(CacheConfiguration.ITEMS_CACHE)
    public Item update(Long id, UpdateItemRequest updateItemRequest) {
        final var item = repository.getOne(id);
        mapper.map(item, updateItemRequest);
        return mapper.map(repository.save(item));
    }

    @Override
    @Transactional
    @CacheEvict(CacheConfiguration.ITEMS_CACHE)
    public void delete(Long id) {
        final var item = repository.getOne(id);
        repository.delete(item);
    }

}
