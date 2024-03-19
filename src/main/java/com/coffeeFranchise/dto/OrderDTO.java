package com.coffeeFranchise.dto;

import com.coffeeFranchise.model.Menu;
import lombok.Data;


import java.math.BigDecimal;

@Data
public class OrderDTO {
    private Long Id;
    private BigDecimal quantity;
    private Menu menu;

    public BigDecimal getItemTotal() {
        return menu.getItemPrice().multiply(quantity);
    }


}