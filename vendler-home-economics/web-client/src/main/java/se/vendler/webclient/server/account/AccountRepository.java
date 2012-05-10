package se.vendler.webclient.server.account;

import se.vendler.economics.account.AccountGroupService;
import se.vendler.economics.account.AccountService;
import se.vendler.economics.util.spring.BeanLocator;
import se.vendler.webclient.client.model.Account;
import se.vendler.webclient.client.model.AccountGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:55 PM
 */
public class AccountRepository {
    private AccountService accountService;
    private AccountGroupService accountGroupService;
    public AccountRepository() {
        accountService= BeanLocator.getBean(AccountService.class);
        accountGroupService=BeanLocator.getBean(AccountGroupService.class);

    }
    public List<Account> getAccounts(Integer accoountGroupId) {
        List<se.vendler.economics.account.Account> accounts = accountService.getAccounts(accoountGroupId);
        List<Account> modelAccounts = new ArrayList<Account>();
        for (se.vendler.economics.account.Account account : accounts) {
            Account modelAccount = new Account();
            modelAccount.setAccountName(account.getAccountName());
            modelAccount.setAccountNumber(String.valueOf(account.getId()));
            modelAccounts.add(modelAccount);
        }
        return modelAccounts;
    }

    public List<AccountGroup> getAccountGroups() {
        List<se.vendler.economics.account.AccountGroup> accountGroups = accountGroupService.getAccountGroups();
        List<AccountGroup> groups = new ArrayList<AccountGroup>();
        for (se.vendler.economics.account.AccountGroup accountGroup : accountGroups) {
            AccountGroup group = new AccountGroup();
            group.setId(accountGroup.getId());
            group.setName(accountGroup.getName());
            groups.add(group);
        }
        return groups;
    }
}
