package com.examplepractice.demo.service;


import com.examplepractice.demo.dto.request.ItemSaveDTO;
import com.examplepractice.demo.paginated.PaginatedItemResponseDTO;

public interface ItemService  {

    String itemSave(ItemSaveDTO itemsaveDTO);

    PaginatedItemResponseDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
