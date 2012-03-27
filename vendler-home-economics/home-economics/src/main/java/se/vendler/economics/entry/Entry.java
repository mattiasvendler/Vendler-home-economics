package se.vendler.economics.entry;

import se.vendler.economics.account.Account;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Mattias Vendler
 * Date: 3/7/12
 * Time: 8:47 PM
 */
public class Entry implements Serializable{
    private String text;
    private Account account;
    private Double amount;
    private Date date;
    private int id;

    public Entry() {
    }

    public Entry(String text, Account account, Double amount, Date date) {
        this.text = text;
        this.account = account;
        this.amount = amount;
        this.date = date;
    }

    public Entry(int id,String text, Account account, Double amount, Date date) {
        this.id=id;
        this.text = text;
        this.account = account;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
