package com.springapp.springradler.service.mapper;

import com.springapp.springradler.service.domain.CreateItemRequest;
import com.springapp.springradler.service.domain.Item;
import com.springapp.springradler.service.domain.UpdateItemRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductItemMapper {

    public Item map(ProductItem productItem) {
        return Item.builder().id(productItem.getId()).title(productItem.getTitle()).build();
    }

    public Page<Item> map(Page<ProductItem> page) {
        return page.map(this::map);
    }

    public ProductItem map(CreateItemRequest createItemRequest) {
        return ProductItem.builder().title(createItemRequest.getTitle()).build();
    }

    public void map(ProductItem item, UpdateItemRequest updateItemRequest) {
        item.setTitle(updateItemRequest.getTitle());
    }

}
