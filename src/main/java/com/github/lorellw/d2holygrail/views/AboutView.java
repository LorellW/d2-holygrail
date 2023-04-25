package com.github.lorellw.d2holygrail.views;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("About")
@PermitAll
@Route(value = "", layout = MainLayout.class)
public class AboutView extends VerticalLayout {


    public AboutView() {

    }
}
