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
    private int accountGroupId;

    public AccountImpl() {
    }

    public AccountImpl(String accountName, String accountNumber, int id, int accountGroupId) {
        this(accountName,accountNumber,id);
        this.accountGroupId=accountGroupId;
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

    public void setAccountGroupId(int accountGroupId) {
        this.accountGroupId = accountGroupId;
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

    @Override
    public int getAccountGroupId() {
        return accountGroupId;
    }
}
