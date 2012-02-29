package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 8:26 PM
 */
@RemoteServiceRelativePath("AccountController")
public interface AccountController extends RemoteService {
    List<Account> getAccounts();
    List<Account> getAccounts(Integer id);
    List<AccountGroup> getAccountGroups();
    /**
     * Utility/Convenience class.
     * Use AccountController.App.getInstance() to access static instance of AccountControllerAsync
     */
    public static class App {
        private static final AccountControllerAsync ourInstance = (AccountControllerAsync) GWT.create(AccountController.class);

        public static AccountControllerAsync getInstance() {
            return ourInstance;
        }
    }
}
