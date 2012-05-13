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

    private Button entriesButton;
    private final Button bankImportButton;
    private final Button entriesStatisticsButton;

    public Menu() {
        VerticalPanel verticalPanel = new VerticalPanel();
        initWidget(verticalPanel);
        verticalPanel.add(new Label("MENU"));
        entriesButton = new Button("Lägg till entries");
        entriesButton.addClickHandler(new EntriesButtonClickHandler());
        verticalPanel.add(entriesButton);
        bankImportButton = new Button("Bank import");
        bankImportButton.addClickHandler(new BankImportButtonClickHandler());
        verticalPanel.add(bankImportButton);
        entriesStatisticsButton = new Button("Statistik");
        entriesStatisticsButton.addClickHandler(new StatisticsButtonClickHandler());
        verticalPanel.add(entriesStatisticsButton);
    }

    private class EntriesButtonClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            RootContainer.setContent(new EntriesPanel());
        }
    }

    private class BankImportButtonClickHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent clickEvent) {
            RootContainer.setContent(new BankImportPanel());
        }
    }

    private class StatisticsButtonClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            RootContainer.setContent(new EntriesStatisticsPanel());
        }
    }
}
