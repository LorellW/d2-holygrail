package com.github.lorellw.d2holygrail.views.itemTabs;

import com.github.lorellw.d2holygrail.entities.ItemTypeMoc;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.HasDataProvider;

public class OtherTab extends ItemTab{
    private ComboBox<ItemTypeMoc> DifficultBox = new ComboBox<>("Diff_Oth");
    private ComboBox<ItemTypeMoc> TypeBox = new ComboBox<>("Type_Oth");
    private ComboBox<ItemTypeMoc> SelectBox = new ComboBox<>("Show_Oth");

    public OtherTab(){
        this.setLabel("Other");
        configBoxes();
        //add(new HorizontalLayout(DifficultBox,TypeBox,SelectBox));
    }

    private void configBoxes(){
        DifficultBox.setItems(ItemTypeMoc.values());
        TypeBox.setItems(ItemTypeMoc.values());
        SelectBox.setItems(ItemTypeMoc.values());
    }

    @Override
    public ComboBox<ItemTypeMoc>[] getComboBoxes() {
        return new ComboBox[]{DifficultBox,TypeBox,SelectBox};
    }

}
