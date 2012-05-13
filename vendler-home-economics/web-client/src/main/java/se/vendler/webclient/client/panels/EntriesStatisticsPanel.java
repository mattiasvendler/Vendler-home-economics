package se.vendler.webclient.client.panels;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import se.vendler.webclient.client.Entries;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.EntriesControllerAsync;
import se.vendler.webclient.client.model.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private CellTable<Entry> table;

    public EntriesStatisticsPanel() {
        init();
        getEntries();
    }

    private void init() {
        // Create a CellTable.
        verticalPanel=new VerticalPanel();
        initWidget(verticalPanel);
        table = new CellTable<Entry>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        // Add a text column to show the name.
        TextColumn<Entry> textColumn = new TextColumn<Entry>() {
            @Override
            public String getValue(Entry object) {
                return object.getText();
            }
        };
        table.addColumn(textColumn, "Text");

        // Add a date column to show the birthday.
    DateCell dateCell = new DateCell();
    Column<Entry, Date> dateColumn = new Column<Entry, Date>(dateCell) {
      @Override
      public Date getValue(Entry object) {
        return object.getDate();
      }
    };
    table.addColumn(dateColumn, "Datum");

        // Add a text column to show the address.
//    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
//      @Override
//      public String getValue(Contact object) {
//        return object.address;
//      }
//    };
//    table.addColumn(addressColumn, "Address");

        // Add a selection model to handle user selection.
        final SingleSelectionModel<Entry> selectionModel = new SingleSelectionModel<Entry>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                Entry selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    Window.alert("You selected: " + selected.getText());
                }
            }
        });
        verticalPanel.add(table);


    }

    private void getEntries() {
        entries = new ArrayList<Entry>();
        entriesController.getAllEntries("", new AsyncCallback<List<Entry>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(List<Entry> result) {
                entries = result;
                table.setRowCount(entries.size(), true);
                table.setPageSize(entries.size());
                table.setPageStart(0);
                table.setRowData(0, entries);

            }
        });
    }


}
