package se.vendler.gwtclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.gwtclient.client.Account;
import se.vendler.gwtclient.client.AccountController;
import se.vendler.gwtclient.client.AccountGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 8:26 PM
 */
public class AccountControllerImpl extends RemoteServiceServlet implements AccountController {

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        Account debitAccount = new Account();
        debitAccount.setAccountName("DebitAccount");
        debitAccount.setAccountNumber("1111");
        Account creditAccount = new Account();
        creditAccount.setAccountName("CreditAccount");
        creditAccount.setAccountNumber("2222");
        accounts.add(debitAccount);
        accounts.add(creditAccount);
        return accounts;
    }

    @Override
    public List<AccountGroup> getAccountGroups() {
        List<AccountGroup> accountGroups = new ArrayList<AccountGroup>();
        AccountGroup accountGroup1 = new AccountGroup();
        accountGroup1.setName("Group1");
        AccountGroup accountGroup2 = new AccountGroup();
        accountGroup2.setName("Group2");
        accountGroups.add(accountGroup1);
        accountGroups.add(accountGroup2);
        return accountGroups;
    }
}