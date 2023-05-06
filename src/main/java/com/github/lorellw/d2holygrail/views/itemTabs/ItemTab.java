package com.github.lorellw.d2holygrail.views.itemTabs;

import com.github.lorellw.d2holygrail.entities.ItemTypeMoc;
import com.github.lorellw.d2holygrail.services.ItemService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;

public abstract class ItemTab extends Tab {

//    private final ItemService itemService;
//
//    public ItemTab(ItemService itemService) {
//        this.itemService = itemService;
//    }

    public abstract ComboBox<ItemTypeMoc>[] getComboBoxes();
}
