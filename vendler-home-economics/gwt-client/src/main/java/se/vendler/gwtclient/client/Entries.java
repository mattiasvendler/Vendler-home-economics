package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 1:28 PM
 */
public class Entries implements EntryPoint {
    private EntriesControllerAsync entriesControllerAsync = EntriesController.App.getInstance();
    private ClientControllerAsync clientControllerAsync = ClientController.App.getInstance();
    private FlowPanel flowPanel;
    private Label statusLabel;
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
        DockPanel dockPanel = new DockPanel();
        initNortPanel();
        dockPanel.add(getNortPanel(), DockPanel.NORTH);
        dockPanel.add(new EntriesPanel(),DockPanel.CENTER);
        RootPanel.get().add(dockPanel);
    }

    private void initNortPanel(){
        flowPanel=getNortPanel();
        statusLabel=new Label("-");
        flowPanel.add(statusLabel);
    }
    private FlowPanel getNortPanel() {
        if (flowPanel == null) {
            flowPanel = new FlowPanel();
        }
        return flowPanel;
    }
}
