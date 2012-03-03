package se.vendler.webclient.client.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import se.vendler.webclient.client.ClientController;
import se.vendler.webclient.client.ClientControllerAsync;
import se.vendler.webclient.client.Content;

/**
 * User: Mattias Vendler
 * Date: 3/3/12
 * Time: 1:32 PM
 */
public class Login extends Composite {
     private ClientControllerAsync clientControllerAsync = ClientController.App.getInstance();
    public Login() {
        init();
    }
    public void init() {
        VerticalPanel loginPanel = new VerticalPanel();
        initWidget(loginPanel);
        final TextBox username = new TextBox();
        Button loginButton = new Button("LoginPanel");
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
                        Content.getInstance().setContent(new BlancPanel());
                        Head.getInstance().setStatus("Logged in");
                    }
                });

            }
        });
    }
}
