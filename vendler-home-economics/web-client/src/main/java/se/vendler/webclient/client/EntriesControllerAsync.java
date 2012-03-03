package se.vendler.webclient.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import se.vendler.webclient.client.model.Entry;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 1:32 PM
 */
public interface EntriesControllerAsync {

    void addEntry(Entry entry, AsyncCallback<Void> async);
}