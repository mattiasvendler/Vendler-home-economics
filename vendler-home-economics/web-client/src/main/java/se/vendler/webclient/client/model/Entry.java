package se.vendler.webclient.client.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Date date;
    private Integer accountGroupId;

    public Entry() {
    }

    public Entry(String id, String text, String account, String amount,Date date,Integer accountGroupId) {
        this(id,text,account,amount,date);
        this.accountGroupId=accountGroupId;
    }

    public Entry(String id, String text, String account, String amount,Date date) {
        this.id = id;
        this.text = text;
        this.account = account;
        this.amount = amount;
        this.date=date;
    }

    public Entry(String text, String account, String amount) {
        this.text = text;
        this.account = account;
        this.amount = amount;
    }

    public Entry(String text, String account, String entryAmount, Date date) {
        this(null,text,account,entryAmount,date);
    }

    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
