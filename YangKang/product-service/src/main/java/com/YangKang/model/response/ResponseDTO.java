package com.YangKang.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private AccountDTO accountDTO;
    private CategoryDTO categoryDTO;
    private ProductDTO productDTO;

}
