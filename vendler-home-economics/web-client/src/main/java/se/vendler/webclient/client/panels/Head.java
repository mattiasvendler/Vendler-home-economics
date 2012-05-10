package se.vendler.webclient.client.panels;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * User: Mattias Vendler
 * Date: 3/3/12
 * Time: 8:39 PM
 */
public class Head extends Composite {
    private static Head head;
    private static Label status;
    private Head() {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        initWidget(horizontalPanel);
        status=new Label("Head");
        horizontalPanel.add(status);
    }

    public static Head getInstance() {
        if (head == null) {
            head=new Head();
        }
        return head;
    }

    public static void setStatus(String message) {
        status.setText(message);
    }
}
