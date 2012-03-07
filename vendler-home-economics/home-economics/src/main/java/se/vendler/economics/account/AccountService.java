package se.vendler.economics.account;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:50 PM
 */
public interface AccountService {
    List<Account> getAccounts(Integer userId);

    Account getAccount(String accountNr);
}
