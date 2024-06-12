package com.examplepractice.demo.paginated;

import com.examplepractice.demo.dto.response.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedItemResponseDTO {
        List<ItemDTO> list;
        private long totalItems;
}
