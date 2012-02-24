package se.vendler.economics.account;

/**
 * User: Mattias Vendler
 * Date: 2/24/12
 * Time: 9:26 PM
 */
public class AbstractAccount implements Account{
    protected String accountName;
    protected String accountNumber;
    protected Double balance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
