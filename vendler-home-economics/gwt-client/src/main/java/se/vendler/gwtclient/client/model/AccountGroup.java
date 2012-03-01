package se.vendler.gwtclient.client.model;

import java.io.Serializable;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 9:52 PM
 */
public class AccountGroup implements Serializable{
    private String name;
    private int id;

    public AccountGroup() {
    }

    public AccountGroup(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
