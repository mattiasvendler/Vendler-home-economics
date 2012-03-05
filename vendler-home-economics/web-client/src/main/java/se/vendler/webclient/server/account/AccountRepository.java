package se.vendler.webclient.server.account;

import se.vendler.economics.account.AccountService;
import se.vendler.economics.util.spring.BeanLocator;
import se.vendler.webclient.client.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:55 PM
 */
public class AccountRepository {
    private AccountService accountService;
    public AccountRepository() {
        accountService= BeanLocator.getBean(AccountService.class);

    }
    public List<Account> getAccounts(Integer userId) {
        List<se.vendler.economics.account.Account> accounts = accountService.getAccounts(userId);
        List<Account> modelAccounts = new ArrayList<Account>();
        for (se.vendler.economics.account.Account account : accounts) {
            Account modelAccount = new Account();
            modelAccount.setAccountName(account.getAccountName());
            modelAccount.setAccountNumber(account.getAccountNumber());
            modelAccounts.add(modelAccount);
        }
        return modelAccounts;
    }
}
