package se.vendler.client.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import se.vendler.client.server.AppServiceImpl;

import java.util.logging.Logger;

public class App implements EntryPoint {
    private final AppServiceAsync appServiceAsync = GWT.create(AppService.class);
    private final Logger logger = Logger.getLogger("testlogger");


    public void onModuleLoad() {
        Button button = new Button("Click me");
        final TextBox textBox = new TextBox();
        textBox.setText("Start värde");
        RootPanel.get("buttonContainer").add(button);
        RootPanel.get("textBoxContainer").add(textBox);
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                appServiceAsync.test(textBox.getText(), new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        logger.info("failure");
                    }

                    @Override
                    public void onSuccess(String result) {
                        textBox.setText(result);
                    }
                });
            }
        });
    }

}
