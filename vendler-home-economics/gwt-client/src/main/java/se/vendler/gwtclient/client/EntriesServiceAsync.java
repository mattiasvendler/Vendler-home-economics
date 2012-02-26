package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface EntriesServiceAsync {
    void getSuggestion(String text, AsyncCallback<String[]> async);


    void getAccounts(AsyncCallback<List<String>> async);
}
