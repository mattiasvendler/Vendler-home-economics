package se.vendler.gwtclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.gwtclient.client.Account;
import se.vendler.gwtclient.client.AccountController;
import se.vendler.gwtclient.client.AccountGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 8:26 PM
 */
public class AccountControllerImpl extends RemoteServiceServlet implements AccountController {

    private static Map<Integer,List<Account>> map;
    private static List<Account> accountsG1;
    private static List<Account> accountsG2;
    private static List<AccountGroup> accountGroups;
    static{
        map = new HashMap<Integer, List<Account>>();
        accountsG1 = new ArrayList<Account>();
        accountsG2 = new ArrayList<Account>();
        accountGroups=new ArrayList<AccountGroup>();

        //Accounts
        Account debitAccount = new Account();
        debitAccount.setAccountName("DebitAccount");
        debitAccount.setAccountNumber("1111");
        Account creditAccount = new Account();
        creditAccount.setAccountName("CreditAccount");
        creditAccount.setAccountNumber("2222");
        accountsG1.add(debitAccount);
        accountsG2.add(creditAccount);

        //AccountGroups
        AccountGroup accountGroup1 = new AccountGroup("Group1",1);
        AccountGroup accountGroup2 = new AccountGroup("Group2",2);
        accountGroups.add(accountGroup1);
        accountGroups.add(accountGroup2);
        map.put(1, accountsG1);
        map.put(2, accountsG2);


    }
    @Override
    public List<Account> getAccounts() {
        getThreadLocalRequest().getSession();
        return accountsG1;
    }

    @Override
    public List<Account> getAccounts(Integer id) {
        return map.get(id);
    }


    @Override
    public List<AccountGroup> getAccountGroups() {
        return accountGroups;
    }
}