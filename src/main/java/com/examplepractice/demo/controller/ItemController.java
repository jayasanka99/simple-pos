package com.examplepractice.demo.controller;

import com.examplepractice.demo.dto.request.ItemSaveDTO;
import com.examplepractice.demo.paginated.PaginatedItemResponseDTO;
import com.examplepractice.demo.service.ItemService;
import com.examplepractice.demo.util.StandardResponse;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@Validated
@RequestMapping("api/v1/item")

public class ItemController {

    private final ItemService itemService;

    @PostMapping(path = "/save")
    public String itemSave(@RequestBody ItemSaveDTO itemsaveDTO) {
        return itemService.itemSave(itemsaveDTO);
    }

    @GetMapping(
            path = "/get-items-with-pagination",
            params = {"activeStatus", "page", "size"}
    )
    public ResponseEntity<StandardResponse>getItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50) int size
    ){
        PaginatedItemResponseDTO paginatedItemResponseDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedItemResponseDTO),
                HttpStatus.OK
        );
    }
}
