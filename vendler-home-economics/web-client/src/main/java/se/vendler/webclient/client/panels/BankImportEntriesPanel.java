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
            for (int i = 1; i < flexTable.getRowCount(); i++) {
                    String text = flexTable.getText(i,1);
                    String date = flexTable.getText(i,2);
//                    flexTable.getText(i,3);
                ListBox accountListBox = (ListBox)flexTable.getWidget(i,4);
                    String accountId = accountListBox.getValue(accountListBox.getSelectedIndex());
                    String amount = flexTable.getText(i, 5);
                ListBox addRemoveListBox = (ListBox) flexTable.getWidget(i,6);
                Entry entry = new Entry(text,accountId,amount,df.parse(date));
                entriesControllerAsync.addEntry(entry,new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }

                    @Override
                    public void onSuccess(Void result) {

                    }
                });
            }
        }
    }

    private void addRow(Entry entries, int rowNumber) {
        Label text = new Label(entries.getText());
        Label date = new Label(df.format(entries.getDate()));
        ListBox accountGroups = getAccountGroups(entries.getAccountGroupId());
        int accountGroupId = entries.getAccountGroupId()!=null && !entries.getAccountGroupId().equals(0)?entries.getAccountGroupId():1;
        ListBox accounts = getAccounts(accountGroupId,entries.getAccount());
        Label amount = new Label(entries.getAmount());
        ListBox addRemoveListBox = new ListBox();
        addRemoveListBox.addItem("Lägg till", "add");
        addRemoveListBox.addItem("Ta bort", "remove");
        buildRow(rowNumber, text, date, accountGroups, accounts, amount, addRemoveListBox);
        accountGroups.addChangeHandler(new AccountGroupSelectedListener(accountGroups, accounts, rowNumber));
    }

    private void buildRow(int rowNumber, Label text, Label date, ListBox accountGroups, ListBox accounts, Label amount, ListBox addRemoveListBox) {
        flexTable.setWidget(rowNumber, 1, text);
        flexTable.setWidget(rowNumber, 2, date);
        flexTable.setWidget(rowNumber, 3, accountGroups);
        flexTable.setWidget(rowNumber, 4, accounts);
        flexTable.setWidget(rowNumber, 5, amount);
        flexTable.setWidget(rowNumber, 6, addRemoveListBox);
    }


    private ListBox getAccounts(int accountGroupId, final String selectedAccount) {
        final ListBox listBox = new ListBox();
        accountControllerAsync.getAccounts(accountGroupId, new AsyncCallback<List<Account>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<Account> result) {
                int i =0;
                int selectedIndex = i;
                for (Account account : result) {
                    if (selectedAccount != null && selectedAccount.equals(account.getAccountName())) {
                      selectedIndex=i;
                    } else {
                        i++;
                    }
                    listBox.addItem(account.getAccountName(), account.getAccountNumber());
                }
                listBox.setSelectedIndex(selectedIndex);
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
            accounts = getAccounts(Integer.valueOf(value),null);
            flexTable.setWidget(rowNumber, 4, accounts);
        }
    }

    private ListBox getAccountGroups(final Integer accountGroupId) {
        final ListBox listBox = new ListBox();
        accountControllerAsync.getAccountGroups(new AsyncCallback<List<AccountGroup>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<AccountGroup> result) {
                int selectedIndex = 1;
                for (int i = 0; i < result.size(); i++) {
                    AccountGroup accountGroup = result.get(i);
                    listBox.addItem(accountGroup.getName(), accountGroup.getId() + "");
                    if ((accountGroupId != null && !accountGroupId.equals(0)) && accountGroupId.intValue() == accountGroup.getId()) {
                        selectedIndex=i;
                    }

                }
                listBox.setSelectedIndex(selectedIndex);
            }
        });
        return listBox;
    }


}
