package se.vendler.webclient.client.model;

import java.io.Serializable;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 9:20 PM
 */
public class Account implements Serializable{
    private String accountName;
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
