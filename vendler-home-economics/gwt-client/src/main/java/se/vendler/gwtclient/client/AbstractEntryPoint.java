package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * User: Mattias Vendler
 * Date: 3/1/12
 * Time: 8:56 PM
 */
public abstract class AbstractEntryPoint implements EntryPoint{
    protected ClientControllerAsync clientControllerAsync = ClientController.App.getInstance();

    @Override
    public void onModuleLoad() {
        clientControllerAsync.isUserLoggedIn(new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(Boolean result) {
                if (!result) {
                    Window.Location.assign("index.html");
                }
            }
        });
    }
}
