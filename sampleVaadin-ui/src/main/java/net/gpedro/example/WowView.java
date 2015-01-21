package net.gpedro.example;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class WowView extends VerticalLayout implements View {

    public WowView() {
        this("nothing here!");
    }
    
    public WowView(String such) {
        addComponent(new Label(such));
    }
    
    @Override
    public void enter(ViewChangeEvent event) {

    }

}
