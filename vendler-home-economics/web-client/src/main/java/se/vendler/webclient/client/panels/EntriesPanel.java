package se.vendler.webclient.client.panels;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import se.vendler.webclient.client.AccountController;
import se.vendler.webclient.client.AccountControllerAsync;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.EntriesControllerAsync;
import se.vendler.webclient.client.model.Account;
import se.vendler.webclient.client.model.AccountGroup;
import se.vendler.webclient.client.model.Entry;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 2:21 PM
 */
public class EntriesPanel extends Composite{
    private EntriesControllerAsync entriesControllerAsync = EntriesController.App.getInstance();
    private AccountControllerAsync accountControllerAsync = AccountController.App.getInstance();
    private FlexTable flexTable;
    private FlexTable entriesTable;
    private VerticalPanel verticalPanel;
    private List<Account> accountsList;
    private ListBox accounts;
    private TextBox entriesText;
    private DatePicker datePicker;
    private DateBox dateBox;

    public EntriesPanel() {
        super();
        init();
    }

    private void init() {
        verticalPanel = new VerticalPanel();
        initWidget(verticalPanel);
        flexTable = new FlexTable();
        entriesTable = new FlexTable();
        verticalPanel.add(flexTable);
        verticalPanel.add(entriesTable);
        entriesText = new TextBox();
	    entriesText.setMaxLength(200);
        entriesText.setVisibleLength(50);;
        entriesText.setAlignment(ValueBoxBase.TextAlignment.RIGHT);
        final ListBox accountGroup = new ListBox();
        accounts = new ListBox();
        final TextBox amount = new TextBox();
        Button addButton = new Button("Lägg till");
	    amount.setMaxLength(5);
        amount.setVisibleLength(5);
        datePicker = new DatePicker();
        dateBox = new DateBox();
        flexTable.setWidget(1,1,entriesText);;
        flexTable.setWidget(1,2, dateBox);;
        flexTable.setWidget(1, 3, accountGroup);
        flexTable.setWidget(1, 4, accounts);
        flexTable.setWidget(1, 5, amount);
        flexTable.setWidget(1, 6, addButton);
        accountsList = new ArrayList<Account>();
        accountControllerAsync.getAccountGroups(new AsyncCallback<List<AccountGroup>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<AccountGroup> result) {
                for (AccountGroup accGroup : result) {
                    accountGroup.addItem(accGroup.getName(),Integer.valueOf(accGroup.getId()).toString());
                }
                accountGroup.setSelectedIndex(0);
            }
        });
        accountControllerAsync.getAccounts(1,new AsyncCallback<List<Account>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<Account> result) {
                accountsList = result;
                setAccountToList(result);

            }
        });
        accountGroup.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                int index = accountGroup.getSelectedIndex();
                String value = accountGroup.getValue(index);
               accountControllerAsync.getAccounts(Integer.valueOf(value),new AsyncCallback<List<Account>>() {
                   @Override
                   public void onFailure(Throwable caught) {
                       //To change body of implemented methods use File | Settings | File Templates.
                   }

                   @Override
                   public void onSuccess(List<Account> result) {
                       setAccountToList(result);
                   }
               });
            }
        });

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String text = entriesText.getText();
                String account = accounts.getValue(accounts.getSelectedIndex());
                String entryAmount = amount.getText();
                Date date = dateBox.getValue();
                Entry entry = new Entry(text,account,entryAmount,date);
                entriesControllerAsync.addEntry(entry, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(Void result) {
                        entriesText.setText("");
                        amount.setText("");
                        updateEntriesList();
                    }
                });
            }
        });
        accountGroup.setVisibleItemCount(1);
        accounts.setVisibleItemCount(1);
    }

    private void updateEntriesList() {
        entriesControllerAsync.getAllEntries("",new AsyncCallback<List<Entry>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<Entry> result) {
                int nextRow = entriesTable.getRowCount()+1;
                for (Entry entry : result) {
                    Label label = new Label(entry.getText());
                    label.setWidth("200");
                    entriesTable.setWidget(nextRow,1,label);
                    entriesTable.setWidget(nextRow,2,new Label(entry.getAccount()));
                    entriesTable.setWidget(nextRow,3,new Label(entry.getAmount()));
                    entriesTable.setWidget(nextRow,4,new Label(entry.getDate().toString()));
                    entriesTable.setWidget(nextRow,5,new Label(""));
                    nextRow++;
                }
            }
        });
    }
    private void setAccountToList(List<Account> accountList) {
        accounts.clear();
        for (Account account : accountList) {
            accounts.addItem(account.getAccountName(),account.getAccountNumber());
        }
    }

}
