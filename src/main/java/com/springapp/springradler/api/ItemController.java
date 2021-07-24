package com.springapp.springradler.api;

import com.springapp.springradler.api.dto.CreateItemDTO;
import com.springapp.springradler.api.dto.UpdateItemDTO;
import com.springapp.springradler.api.mapper.ItemApiMapper;
import com.springapp.springradler.service.ItemService;
import com.springapp.springradler.service.domain.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import static com.springapp.springradler.api.ItemController.ENDPOINT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    public Item create(@RequestBody CreateItemDTO createItemDto) {
        return service.create(mapper.map(createItemDto));
    }

    @PutMapping(value = ENDPOINT_BY_ID)
    public Item update(@PathVariable Long id, @RequestBody UpdateItemDTO updateItemDto) {
        return service.update(id, mapper.map(updateItemDto));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = ENDPOINT_BY_ID)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}