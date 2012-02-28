package se.vendler.economics.account;

import java.io.Serializable;

/**
 * User: mattias
 * Date: 2/24/12
 * Time: 9:23 PM
 */
public interface Account extends Serializable{
    String getAccountName();

    void setAccountName(String accountName);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    Double getBalance();

    void setBalance(Double balance);
}
