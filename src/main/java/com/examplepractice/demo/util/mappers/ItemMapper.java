package com.examplepractice.demo.util.mappers;

import com.examplepractice.demo.dto.response.ItemDTO;
import com.examplepractice.demo.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemDTO> PageListToDTOList(Page<Item> items);
}
