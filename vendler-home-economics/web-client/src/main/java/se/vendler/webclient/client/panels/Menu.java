package se.vendler.webclient.client.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import se.vendler.webclient.client.Content;


/**
 * User: Mattias Vendler
 * Date: 3/3/12
 * Time: 8:39 PM
 */
public class Menu extends Composite{
    public Menu() {
        VerticalPanel verticalPanel = new VerticalPanel();
        initWidget(verticalPanel);
        verticalPanel.add(new Label("MENU"));
        Button entriesButton = new Button("Lägg till entries");
        verticalPanel.add(entriesButton);
        entriesButton.addClickHandler(new EntriesButtonClickHandler());
    }

    private class EntriesButtonClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            Content.getInstance().setContent(new EntriesPanel());
        }
    }
}
