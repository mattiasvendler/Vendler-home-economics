package se.vendler.economics.entry;

import se.vendler.economics.account.Account;
import se.vendler.economics.account.AccountGroup;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 3/24/12
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImportedEntry extends Entry  {
    private Account accountSuggestion;
    private AccountGroup accountGroupSuggestion;
    private boolean duplicate;



    public Account getAccountSuggestion() {
        return accountSuggestion;
    }

    public void setAccountSuggestion(Account accountSuggestion) {
        this.accountSuggestion = accountSuggestion;
    }

    public AccountGroup getAccountGroupSuggestion() {
        return accountGroupSuggestion;
    }

    public void setAccountGroupSuggestion(AccountGroup accountGroupSuggestion) {
        this.accountGroupSuggestion = accountGroupSuggestion;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
}
