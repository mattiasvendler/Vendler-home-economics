package se.vendler.webclient.client.panels;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import se.vendler.webclient.client.AccountController;
import se.vendler.webclient.client.AccountControllerAsync;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.EntriesControllerAsync;
import se.vendler.webclient.client.model.Account;
import se.vendler.webclient.client.model.AccountGroup;
import se.vendler.webclient.client.model.Entry;

import java.util.Date;
import java.util.List;

/**
 * User: mattias
 * Date: 3/20/12
 * Time: 8:38 PM
 */
public class BankImportEntriesPanel extends Composite {
    private FlexTable flexTable;
    private AccountControllerAsync accountControllerAsync = AccountController.App.getInstance();
    private EntriesControllerAsync entriesControllerAsync = EntriesController.App.getInstance();
    private DateTimeFormat df = DateTimeFormat.getFormat("yyyy-MM-dd");

    public BankImportEntriesPanel(List<Entry> entries) {
        VerticalPanel verticalPanel = new VerticalPanel();
        initWidget(verticalPanel);
        flexTable = new FlexTable();
        int i = 1;
        for (Entry entry : entries) {
            addRow(entry, i++);
        }
        verticalPanel.add(flexTable);
        Button importButton = new Button("Importera");
        importButton.addClickHandler(new ImportClickHandler());
        verticalPanel.add(importButton);

    }

    private class ImportClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            for (int i = 1; i <= flexTable.getRowCount(); i++) {
                    String text = flexTable.getText(i,1);
                    String date = flexTable.getText(i,2);
//                    flexTable.getText(i,3);
                ListBox accountListBox = (ListBox)flexTable.getWidget(i,4);
                    String account = accountListBox.getValue(accountListBox.getSelectedIndex());
                    String amount = flexTable.getText(i, 5);
                ListBox addRemoveListBox = (ListBox) flexTable.getWidget(i,6);
                Entry entry = new Entry(text,account,amount,df.parse(date));
                entriesControllerAsync.addEntry(entry,new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(Void result) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }
                });
            }
        }
    }

    private void addRow(Entry entries, int rowNumber) {
        Label text = new Label(entries.getText());
        Label date = new Label(df.format(entries.getDate()));
        ListBox accountGroups = getAccountGroups();
        int accountGroupId = accountGroups.getSelectedIndex();
        ListBox accounts = getAccounts(1);
        Label amount = new Label(entries.getAmount());
        ListBox addRemoveListBox = new ListBox();
        addRemoveListBox.addItem("Lägg till", "add");
        addRemoveListBox.addItem("Ta bort", "remove");
        flexTable.setWidget(rowNumber, 1, text);
        flexTable.setWidget(rowNumber, 2, date);
        flexTable.setWidget(rowNumber, 3, accountGroups);
        flexTable.setWidget(rowNumber, 4, accounts);
        flexTable.setWidget(rowNumber, 5, amount);
        flexTable.setWidget(rowNumber, 6, addRemoveListBox);
        accountGroups.addChangeHandler(new AccountGroupSelectedListener(accountGroups, accounts, rowNumber));
    }


    private ListBox getAccounts(int accountGroupId) {
        final ListBox listBox = new ListBox();
        accountControllerAsync.getAccounts(accountGroupId, new AsyncCallback<List<Account>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<Account> result) {
                for (Account account : result) {
                    listBox.addItem(account.getAccountName(), account.getAccountNumber());
                }
            }
        });
        return listBox;
    }

    private class AccountGroupSelectedListener implements ChangeHandler {
        private ListBox accountGroups;
        private ListBox accounts;
        private int rowNumber;

        private AccountGroupSelectedListener(ListBox accountGroups, ListBox accounts, int rowNumber) {
            this.accountGroups = accountGroups;
            this.accounts = accounts;
            this.rowNumber = rowNumber;
        }

        @Override
        public void onChange(ChangeEvent event) {
            int selectedIndex = accountGroups.getSelectedIndex();
            String value = accountGroups.getValue(selectedIndex);
            accounts = getAccounts(Integer.valueOf(value));
            flexTable.setWidget(rowNumber, 4, accounts);
        }
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
                    listBox.addItem(accountGroup.getName(), accountGroup.getId() + "");
                }
                listBox.setSelectedIndex(1);
            }
        });
        return listBox;
    }


}
