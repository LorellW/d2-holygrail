package com.github.lorellw.d2holygrail.views;

import com.github.lorellw.d2holygrail.views.itemTabs.ArmorTab;
import com.github.lorellw.d2holygrail.views.itemTabs.ItemTab;
import com.github.lorellw.d2holygrail.views.itemTabs.OtherTab;
import com.github.lorellw.d2holygrail.views.itemTabs.WeaponTab;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

import java.util.Arrays;

@PermitAll
@PageTitle("Holy Grail")
@Route(value = "holygrail", layout = MainLayout.class)
public class HolyGrailView extends VerticalLayout {
    private ItemTab armor = new ArmorTab();
    private ItemTab weapon = new WeaponTab();
    private ItemTab other = new OtherTab();

    private Tabs tabs;
    private HorizontalLayout content = new HorizontalLayout();

    public HolyGrailView(){

        configTabs();
        add(tabs,content);
    }

    private void configTabs() {
        content.setSpacing(true);

        tabs = new Tabs();
        tabs.setAutoselect(false);

        tabs.addSelectedChangeListener(event -> {
            content.removeAll();
            content.add(((ItemTab)event.getSelectedTab()).getComboBoxes());
        });
        tabs.add(armor,weapon,other);


    }

}
