package com.springapp.springradler.api;

import com.springapp.springradler.api.mapper.ItemApiMapper;
import com.springapp.springradler.service.ItemService;
import com.springapp.springradler.service.domain.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // generates a constructor for final fields
@RequestMapping(value = ENDPOINT, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class ItemController {

    public static final String ENDPOINT = "/items";
    public static final String ENDPOINT_BY_ID = "/{id}";

    private final ItemService service;
    private final ItemApiMapper mapper;

    @GetMapping
    public Page<Item> find(@PageableDefault(sort = "id") Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = ENDPOINT_BY_ID)
    public Item get(@PathVariable Long id) {
        return service.getOne(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public Item create(@RequestBody CreateItemDto createItemDto) {
        return service.create(mapper.map(createItemDto));
    }

    @PutMapping(value = ENDPOINT_BY_ID)
    public Item update(@PathVariable Long id, @RequestBody UpdateItemDto updateItemDto) {
        return service.update(id, mapper.map(updateItemDto));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = ENDPOINT_BY_ID)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}