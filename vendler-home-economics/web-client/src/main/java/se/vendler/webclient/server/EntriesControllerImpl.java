package se.vendler.webclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.stereotype.Controller;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.model.Entry;

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

    @Override
    public List<Entry> getAllEntries() {
        return entries;
    }
}