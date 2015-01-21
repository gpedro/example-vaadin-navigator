package net.gpedro.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("net.gpedro.example.MyAppWidgetset")
public class MainUI extends UI {

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    Navigator navigator;
    
    private Command openMenu(final String viewId) {
        return new Command() {
            private static final long serialVersionUID = 1L;

            @Override
            public void menuSelected(MenuItem selectedItem) {
                if(!viewId.equals("not-implemented")) {
                    navigator.navigateTo(viewId);
                }
            }
        };
    }
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        VerticalLayout content = new VerticalLayout();

        navigator = new Navigator(this, content);  
        
        // registering routes
        navigator.addView("", new MainView());
        navigator.addView("dog", new WowView("au au!"));
        navigator.addView("cat", new WowView("meow meow!"));
        navigator.addView("mafagafos", new WowView("o9kspf0ujwe89r3jqwp"));
        navigator.addView("huehue", new WowView("HuEHEUHEuHUHueE"));
        navigator.addView("brbr", new WowView("BRBRBR HueHueHEuE"));
        
        HorizontalLayout divs = new HorizontalLayout();
        
        MenuBar menu = new MenuBar();
        menu.setAutoOpen(true);
        MenuItem item1  = menu.addItem("Item1", openMenu("dog"));
        MenuItem item11 = item1.addItem("Item1.1", openMenu("cat"));

        MenuItem item2  = menu.addItem("Item2", openMenu("mafagafos"));
        MenuItem item3  = menu.addItem("Item3", openMenu("huehue"));
        MenuItem item31 = item3.addItem("Item3.1", openMenu("brbr"));
        
        // description used to make routes
        item1.setDescription("");
        item11.setDescription("dog");
        
        divs.addComponents(menu, content);
        layout.addComponent(divs);
    }

}
