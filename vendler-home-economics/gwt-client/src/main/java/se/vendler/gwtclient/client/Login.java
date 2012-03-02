package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * User: Mattias Vendler
 * Date: 3/1/12
 * Time: 9:07 PM
 */
public class Login implements EntryPoint {
    private ClientControllerAsync clientControllerAsync = ClientController.App.getInstance();
    public void onModuleLoad() {
        VerticalPanel loginPanel = new VerticalPanel();
        final TextBox username = new TextBox();
        Button loginButton = new Button("Login");
        final PasswordTextBox passwordTextBox = new PasswordTextBox();
        loginPanel.add(username);
        loginPanel.add(passwordTextBox);
        loginPanel.add(loginButton);

        loginButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                clientControllerAsync.login(username.getText(),passwordTextBox.getText(),new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        if (result) {
                            Window.Location.assign("Entries.html");
                        }
                    }
                });
            }
        });
        RootPanel.get().add(loginPanel);
    }

}
