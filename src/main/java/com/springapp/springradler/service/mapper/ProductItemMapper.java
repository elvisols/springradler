package com.springapp.springradler.service.mapper;

import com.springapp.springradler.data.entity.ProductItem;
import com.springapp.springradler.service.domain.CreateItemRequest;
import com.springapp.springradler.service.domain.Item;
import com.springapp.springradler.service.domain.UpdateItemRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductItemMapper {

    default Page<Item> map(Page<ProductItem> page) {
        return page.map(this::map);
    }

    Item map(ProductItem productItem);

    @Mapping(target = "id", ignore = true)
    ProductItem map(CreateItemRequest createItemRequest);

    @Mapping(target = "id", ignore = true)
    void map(@MappingTarget ProductItem item, UpdateItemRequest updateItemRequest);

}
