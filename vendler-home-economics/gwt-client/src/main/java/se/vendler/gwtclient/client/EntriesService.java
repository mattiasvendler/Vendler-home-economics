package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/24/12
 * Time: 10:25 PM
 */
@RemoteServiceRelativePath("EntriesService")
public interface EntriesService extends RemoteService{
    String[] getSuggestion(String text);

    List<String> getAccounts();
}
