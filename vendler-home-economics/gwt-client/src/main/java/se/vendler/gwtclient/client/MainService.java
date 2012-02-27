package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * User: Mattias Vendler
 * Date: 2/27/12
 * Time: 7:40 PM
 */
@RemoteServiceRelativePath("MainService")
public interface MainService extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use MainService.App.getInstance() to access static instance of MainServiceAsync
     */
    public static class App {
        private static final MainServiceAsync ourInstance = (MainServiceAsync) GWT.create(MainService.class);

        public static MainServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
