package se.vendler.webclient.client.panels;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import se.vendler.webclient.client.Entries;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.EntriesControllerAsync;
import se.vendler.webclient.client.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 5/12/12
 * Time: 10:05 PM
 */
public class EntriesStatisticsPanel extends Composite {

    private VerticalPanel verticalPanel;
    private EntriesControllerAsync entriesController = EntriesController.App.getInstance();
    private List<Entry> entries;
    private CellTable cellTable;

    public EntriesStatisticsPanel() {
        getEntries();
        init();
    }

    private void init() {
        cellTable = new CellTable<Entries>();
        initWidget(cellTable);
        cellTable.setWidth("100%");
        TextColumn<Entry> textColumn = new TextColumn<Entry>() {
            @Override
            public String getValue(Entry object) {
                return object.getText();
            }
        };
        cellTable.setHeight("100%");
        cellTable.addColumn(textColumn);
        cellTable.setColumnWidth(textColumn, "30%");
        verticalPanel.add(cellTable);

    }

    private void getEntries() {
        entries = new ArrayList<Entry>();
        entriesController.getAllEntries("", new AsyncCallback<List<Entry>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(List<Entry> result) {
                entries =result;
                cellTable.setRowCount(entries.size(), true);
                cellTable.setRowData(0, entries);

            }
        });
    }
}
