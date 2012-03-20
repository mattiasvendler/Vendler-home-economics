package se.vendler.webclient.client.panels;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import se.vendler.webclient.client.AccountController;
import se.vendler.webclient.client.AccountControllerAsync;
import se.vendler.webclient.client.model.AccountGroup;
import se.vendler.webclient.client.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mattias
 * Date: 3/20/12
 * Time: 8:38 PM
 */
public class BankImportEntriesPanel extends Composite {
    private FlexTable flexTable;
    private AccountControllerAsync accountControllerAsync = AccountController.App.getInstance();

    public BankImportEntriesPanel(List<Entry> entries) {
        flexTable = new FlexTable();
        initWidget(flexTable);
        int i =1;
        for (Entry entry : entries) {
           addRow(entry,i++);
        }

    }

    private void addRow(Entry entries, int rowNumber) {
        Label text = new Label(entries.getText());
        Label date = new Label(entries.getDate().toString());
        ListBox account = getAccountGroups();
        Label amount = new Label(entries.getAmount());
//        Label text = new Label(entries.getText());
        flexTable.setWidget(rowNumber,1,text);
        flexTable.setWidget(rowNumber,2,date);
        flexTable.setWidget(rowNumber,3,account);
        flexTable.setWidget(rowNumber, 4, amount);
    }

    private ListBox getAccountGroups() {
        final ListBox listBox = new ListBox();
        accountControllerAsync.getAccountGroups(new AsyncCallback<List<AccountGroup>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<AccountGroup> result) {
                for (int i = 0; i < result.size(); i++) {
                    AccountGroup accountGroup = result.get(i);
                    listBox.addItem(accountGroup.getName(), accountGroup.getId()+"");
                }
            }
        });
        return listBox;
    }


}
