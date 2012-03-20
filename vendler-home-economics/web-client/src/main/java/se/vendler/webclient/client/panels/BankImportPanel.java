package se.vendler.webclient.client.panels;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import se.vendler.economics.EconomicsService;
import se.vendler.economics.util.spring.BeanLocator;
import se.vendler.webclient.client.Entries;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.EntriesControllerAsync;
import se.vendler.webclient.client.model.Entry;

import java.util.List;

/**
 * User: mattias
 * Date: 3/18/12
 * Time: 9:01 PM
 */
public class BankImportPanel extends Composite {
    private EntriesControllerAsync entriesControllerAsync = EntriesController.App.getInstance();
    private TextArea textArea;

    public BankImportPanel() {
        FlowPanel flowPanel = new FlowPanel();
        initWidget(flowPanel);
        textArea = new TextArea();
        textArea.setVisibleLines(30);
        textArea.setWidth("800px");
        flowPanel.add(textArea);
        Button button = new Button("Import");
        flowPanel.add(button);
        button.addClickHandler(new ImportButtonHandler());
    }

    private class ImportButtonHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent clickEvent) {
            entriesControllerAsync.importEntries(textArea.getText(),new AsyncCallback<List<Entry>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void onSuccess(List<Entry> entries) {
                    RootContainer.setContent(new BankImportEntriesPanel(entries));
                }
            });
        }
    }
}
