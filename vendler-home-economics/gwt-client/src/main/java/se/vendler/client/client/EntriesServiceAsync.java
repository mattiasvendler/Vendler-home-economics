package se.vendler.client.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

public interface EntriesServiceAsync {
    void getSuggestion(String text, AsyncCallback<String[]> async);


    void getAccounts(AsyncCallback<List<String>> async);
}
