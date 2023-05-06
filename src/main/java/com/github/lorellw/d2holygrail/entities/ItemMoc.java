package com.github.lorellw.d2holygrail.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemMoc {
    private Long id;
    private String name;
    private ItemTypeMoc type;
    private ItemTypeMoc difficult;
    private ItemTypeMoc founded;
}
