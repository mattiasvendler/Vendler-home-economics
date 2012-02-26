package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/24/12
 * Time: 9:37 PM
 */
public class Entries implements EntryPoint {
    private final EntriesServiceAsync entriesServiceAsync = GWT.create(EntriesService.class);

    public void onModuleLoad() {
        TextBox entryTextBox = new TextBox();
        final ListBox accounts = new ListBox();
        TextBox amountTextBox = new TextBox();
        FlowPanel flowPanel = new FlowPanel();
        flowPanel.add(entryTextBox);
        flowPanel.add(accounts);
        flowPanel.add(amountTextBox);
        entriesServiceAsync.getAccounts(new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(List<String> result) {
                for (String accountString : result) {
                    accounts.addItem(accountString);
                }
            }
        });

        accounts.setVisibleItemCount(1);
        RootPanel.get("entries").add(flowPanel);
    }

}
