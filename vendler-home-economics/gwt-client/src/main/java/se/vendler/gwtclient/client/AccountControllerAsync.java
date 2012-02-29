package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 8:26 PM
 */
public interface AccountControllerAsync {
    void getAccounts(AsyncCallback<List<Account>> async);

    void getAccountGroups(AsyncCallback<List<AccountGroup>> async);

    void getAccounts(Integer id, AsyncCallback<List<Account>> async);
}
