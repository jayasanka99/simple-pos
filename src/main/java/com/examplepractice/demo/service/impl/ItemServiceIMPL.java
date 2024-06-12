package com.examplepractice.demo.service.impl;

import com.examplepractice.demo.dto.request.ItemSaveDTO;
import com.examplepractice.demo.entity.Item;
import com.examplepractice.demo.exception.NotFoundException;
import com.examplepractice.demo.paginated.PaginatedItemResponseDTO;
import com.examplepractice.demo.repo.ItemRepo;
import com.examplepractice.demo.service.ItemService;
import com.examplepractice.demo.util.mappers.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ItemServiceIMPL implements ItemService {

    private final ItemRepo itemRepo;
    private final ModelMapper modelMapper;
    private final ItemMapper itemMapper;

    @Override
    public String itemSave(ItemSaveDTO itemsaveDTO) {
        Item item = modelMapper.map(itemsaveDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemName() + " Added Successfully";
        } else {
            return "Item already exists";
        }
    }

    @Override
    public PaginatedItemResponseDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        if (items.getSize() < 1) {
            throw new NotFoundException("No Data found");
        }
        return new PaginatedItemResponseDTO(
                itemMapper.PageListToDTOList(items),
                itemRepo.countAllByActiveStateEquals(activeStatus)
        );
    }
}
