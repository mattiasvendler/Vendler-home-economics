package se.vendler.webclient.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import se.vendler.webclient.client.panels.Login;
import se.vendler.webclient.client.panels.RootContainer;


import static com.google.gwt.user.client.ui.RootPanel.get;

/**
 * User: Mattias Vendler
 * Date: 3/3/12
 * Time: 8:16 PM
 */
public class Content extends Composite {
    private static ClientControllerAsync clientControllerAsync = ClientController.App.getInstance();
    private static Content INSTANCE;

    public static Content getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Content();
        }
        return INSTANCE;
    }

    private Content() {

    }

    public static void setContent(Composite content) {
        isLoggedIn();
//        get("content").clear();
//        get("content").add(content);
        RootContainer.setContent(content);
    }

    private static void isLoggedIn() {
        final boolean loggedIn = false;
        clientControllerAsync.isUserLoggedIn(new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(Boolean result) {
                if (!result) {
                    RootContainer.setContent(new Login());
                }
            }
        });
    }
}
