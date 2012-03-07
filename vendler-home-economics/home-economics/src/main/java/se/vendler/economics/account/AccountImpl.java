package se.vendler.economics.account;

/**
 * User: Mattias Vendler
 * Date: 2/24/12
 * Time: 9:26 PM
 */
public class AccountImpl implements Account{
    protected String accountName;
    protected String accountNumber;
    protected Double balance;
    private int id;

    public AccountImpl() {
    }

    public AccountImpl(String accountName, String accountNumber, int id) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.id = id;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
