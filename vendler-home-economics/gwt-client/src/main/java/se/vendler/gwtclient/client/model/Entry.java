package se.vendler.gwtclient.client.model;

import java.io.Serializable;

/**
 * User: Mattias Vendler
 * Date: 2/29/12
 * Time: 9:23 PM
 */
public class Entry implements Serializable{
    private String id;
    private String text;
    private String account;
    private String amount;

    public Entry() {
    }

    public Entry(String id, String text, String account, String amount) {
        this.id = id;
        this.text = text;
        this.account = account;
        this.amount = amount;
    }

    public Entry(String text, String account, String amount) {
        this.text = text;
        this.account = account;
        this.amount = amount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
