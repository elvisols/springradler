package com.springapp.springradler.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.springapp.springradler.service.domain.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ItemService {

    Page<Item> findAll(@NotNull Pageable pageable);

    Item getOne(@NotNull Long id);

    Item create(@NotNull @Valid CreateItemRequest createItemRequest);

    Item update(@NotNull Long id, @Valid UpdateItemRequest updateItemRequest);

    void delete(@NotNull Long id);
    
}
