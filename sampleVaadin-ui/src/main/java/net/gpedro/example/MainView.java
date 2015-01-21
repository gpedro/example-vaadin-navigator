package net.gpedro.example;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeEvent event) {
        addComponent(new Label("MainView"));
    }

}
