package com.github.lorellw.d2holygrail.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Holy Grail")
@Route(value = "holygrail", layout = MainLayout.class)
public class HolyGrailView extends VerticalLayout {
    private TextField textField;

    public HolyGrailView(){

    }

    private void configTextField(){

    }
}
