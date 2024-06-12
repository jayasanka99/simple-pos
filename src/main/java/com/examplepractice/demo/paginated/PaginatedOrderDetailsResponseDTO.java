package com.examplepractice.demo.paginated;

import com.examplepractice.demo.dto.response.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedOrderDetailsResponseDTO {
    private List<OrderDetailsDTO> list;
    private long dataCount;
}
