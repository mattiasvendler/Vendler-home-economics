package se.vendler.gwtclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.gwtclient.client.EntriesController;
import se.vendler.gwtclient.client.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 1:32 PM
 */
public class EntriesControllerImpl extends RemoteServiceServlet implements EntriesController {
    private static List<Entry> entries = new ArrayList<Entry>();
    @Override
    public void addEntry(Entry entry) {
        entries.add(entry);
    }
}