package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * User: Mattias Vendler
 * Date: 2/29/12
 * Time: 10:11 PM
 */
@RemoteServiceRelativePath("ClientController")
public interface ClientController extends RemoteService {

    Boolean isUserLoggedIn();
    Boolean login(String userName,String password);

    /**
     * Utility/Convenience class.
     * Use ClientController.App.getInstance() to access static instance of ClientControllerAsync
     */
    public static class App {
        private static final ClientControllerAsync ourInstance = (ClientControllerAsync) GWT.create(ClientController.class);

        public static ClientControllerAsync getInstance() {
            return ourInstance;
        }
    }
}
