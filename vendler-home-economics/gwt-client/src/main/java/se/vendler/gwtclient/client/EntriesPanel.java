package se.vendler.gwtclient.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 2:21 PM
 */
public class EntriesPanel extends Composite{
    private EntriesControllerAsync entriesControllerAsync = EntriesController.App.getInstance();
    private AccountControllerAsync accountControllerAsync = AccountController.App.getInstance();
    private FlowPanel flexTable;
    private List<Account> accountsList;
    private ListBox accounts;

    public EntriesPanel() {
        init();
    }

    private void init() {
        flexTable = new FlowPanel();
        initWidget(flexTable);
        TextBox entriesText = new TextBox();
        final ListBox accountGroup = new ListBox();
        accounts = new ListBox();
        TextBox amount = new TextBox();
        flexTable.add(entriesText);
        flexTable.add(accountGroup);
        flexTable.add(accounts);
        flexTable.add(amount);
        accountsList = new ArrayList<Account>();
        List<AccountGroup> accountGroups = new ArrayList<AccountGroup>();
        accountControllerAsync.getAccountGroups(new AsyncCallback<List<AccountGroup>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<AccountGroup> result) {
                for (AccountGroup accGroup : result) {
                    accountGroup.addItem(accGroup.getName());
                }
            }
        });
        accountControllerAsync.getAccounts(new AsyncCallback<List<Account>>() {
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
               accountControllerAsync.getAccounts(new AsyncCallback<List<Account>>() {
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
        accountGroup.setVisibleItemCount(1);
        accounts.setVisibleItemCount(1);
    }

    private void setAccountToList(List<Account> accountList) {
        for (Account account : accountList) {
            accounts.addItem(account.getAccountName());
        }
    }

}
