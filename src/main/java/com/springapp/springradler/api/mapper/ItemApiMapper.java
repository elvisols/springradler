package com.springapp.springradler.api.mapper;

import com.springapp.springradler.api.dto.CreateItemDTO;
import com.springapp.springradler.api.dto.UpdateItemDTO;

import org.springframework.stereotype.Component;

@Component
public class ItemApiMapper {

    public CreateItemRequest map(CreateItemDTO createItemDto) {

        return CreateItemRequest.builder()
                .title(createItemDto.getTitle())
                .build();
    }

    public UpdateItemRequest map(UpdateItemDTO updateItemDto) {
        
        return UpdateItemRequest.builder()
                .title(updateItemDto.getTitle())
                .build();
    }
    
}
