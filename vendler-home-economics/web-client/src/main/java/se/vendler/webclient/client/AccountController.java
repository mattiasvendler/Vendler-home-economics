package se.vendler.webclient.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.springframework.stereotype.Controller;
import se.vendler.webclient.client.model.Account;
import se.vendler.webclient.client.model.AccountGroup;

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
