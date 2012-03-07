package se.vendler.economics.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 9:43 PM
 */
@Component
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDAO dao;
    @Override
    public List<Account> getAccounts(Integer accountGroupId) {
        return dao.getAccounts(accountGroupId);
    }

    @Override
    public Account getAccount(String accountNr) {
        return dao.getAccount(accountNr);
    }
}
