package com.YangKang.model.repsonse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private ProductDTO productDTO;
    private CartDTO cartDTO;
}
