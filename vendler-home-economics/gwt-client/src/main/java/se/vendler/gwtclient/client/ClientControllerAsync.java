package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * User: Mattias Vendler
 * Date: 2/29/12
 * Time: 10:11 PM
 */
public interface ClientControllerAsync {

    void isUserLoggedIn(AsyncCallback<Boolean> async);

    void login(String userName, String password, AsyncCallback<Boolean> async);
}
