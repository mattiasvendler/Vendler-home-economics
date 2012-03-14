package se.vendler.webclient.client.panels;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 3/14/12
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class RootContainer extends Composite {
    private static RootContainer INSTANCE;
    private static DockPanel dockPanel;
    private static Composite content;

    private RootContainer() {
        dockPanel = new DockPanel();
        initWidget(dockPanel);
        dockPanel.add(Head.getInstance(), DockPanel.NORTH);
        dockPanel.add(new BlancPanel(), DockPanel.SOUTH);
        dockPanel.add(new Menu(), DockPanel.WEST);
        dockPanel.add(new BlancPanel(), DockPanel.EAST);
        content = new Login();
        dockPanel.add(content, DockPanel.CENTER);
    }

    public static RootContainer get() {
        if (INSTANCE == null) {
            INSTANCE = new RootContainer();
        }
        return INSTANCE;
    }

    public static void setContent(Composite composite) {
        dockPanel.getWidget(dockPanel.getWidgetIndex(content)).removeFromParent();
        dockPanel.add(composite, DockPanel.CENTER);
    }
}
