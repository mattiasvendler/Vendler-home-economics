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

public class App implements EntryPoint {
    private final AppServiceAsync appServiceAsync = GWT.create(AppService.class);
//    private AppService appService = new AppServiceImpl();
	public void onModuleLoad() {
		Button button = new Button("Click me");
        final TextBox textBox = new TextBox();
		RootPanel.get("buttonContainer").add(button);
        RootPanel.get("textBoxContainer").add(textBox);

        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                appServiceAsync.test(new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(String result) {
                        AppService appService = new AppServiceImpl();
                      textBox.setText(appService.test());
                    }
                }) ;
            }
        });
	}

}
