package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;

/**
 * User: Mattias Vendler
 * Date: 2/27/12
 * Time: 7:39 PM
 */
public class Main implements EntryPoint {
    private MainServiceAsync mainServiceAsync = MainService.App.getInstance();
    private DockPanel dockPanel;
    private Widget currentCenter;

    public void onModuleLoad() {
        dockPanel = new DockPanel();
        MenuBar menuBar = new MenuBar();
        MenuBar fileSubMenu = new MenuBar();
        MenuItem fileMenuItem = new MenuItem("File",fileSubMenu);
        menuBar.addItem(fileMenuItem);
        MenuItem openMenuItem = new MenuItem("Open",new Command() {
            @Override
            public void execute() {
                loadCenter();
            }
        });
        fileSubMenu.addItem(openMenuItem);
        new Button("Knapp1");
        Button button2 = new Button("Knapp2");
        Button button3 = new Button("Knapp3");
        currentCenter = button3;
        dockPanel.add(menuBar, DockPanel.NORTH);
        dockPanel.add(button2, DockPanel.WEST);
        dockPanel.add(button3, DockPanel.CENTER);
        RootPanel.get().add(dockPanel);
    }
    private void loadCenter() {
        Entries entries = new Entries();
        dockPanel.remove(currentCenter);
        dockPanel.add(entries, DockPanel.CENTER);
        currentCenter=entries;
        currentCenter.setVisible(true);
    }
}
