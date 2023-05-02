package com.github.lorellw.d2holygrail.views;

import com.github.lorellw.d2holygrail.services.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    private final SecurityService securityService;

    public MainLayout(SecurityService securityService){
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader(){
        H3 logo = new H3("D2R Holy Grail");
        logo.addClassNames("text-l", "m-m");

        Button logoutButton = new Button("Log out", buttonClickEvent -> {
            try {
                securityService.logout();
            }catch (IllegalStateException ignored){

            }
        });

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo,
                logoutButton
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.BASELINE);
        header.expand(logo);
        header.setWidth("99%");
        header.addClassNames("py-0","px-m");

        addToNavbar(header);
    }

    private void createDrawer(){
        RouterLink aboutLink = new RouterLink("About", AboutView.class);
        RouterLink hgLink = new RouterLink("Holy grail", HolyGrailView.class);

        addToDrawer(
                new VerticalLayout(
                        hgLink,
                        aboutLink
                )
        );
    }

    private void configLogOutButton(){

    }
}
