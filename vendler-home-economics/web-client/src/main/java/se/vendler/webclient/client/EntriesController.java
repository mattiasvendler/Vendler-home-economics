package se.vendler.webclient.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import se.vendler.webclient.client.model.Entry;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 1:32 PM
 */
@RemoteServiceRelativePath("EntriesController")
public interface EntriesController extends RemoteService {
    void addEntry(Entry entry);

    List<Entry> getAllEntries(String userId);

    List<Entry> importEntries(String importString);

    /**
     * Utility/Convenience class.
     * Use EntriesController.App.getInstance() to access static instance of EntriesControllerAsync
     */
    public static class App {
        private static final EntriesControllerAsync ourInstance = (EntriesControllerAsync) GWT.create(EntriesController.class);

        public static EntriesControllerAsync getInstance() {
            return ourInstance;
        }
    }
}
