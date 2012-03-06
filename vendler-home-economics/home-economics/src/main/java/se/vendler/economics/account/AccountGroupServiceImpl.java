package se.vendler.economics.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/6/12
 * Time: 8:43 PM
 */
@Component
public class AccountGroupServiceImpl implements AccountGroupService{
    @Autowired
    private AccountGroupDAO accountGroupDAO;

    @Override
    public List<AccountGroup> getAccountGroups() {
        return accountGroupDAO.getAccountGroups();
    }
}
