package se.vendler.gwtclient.client;

import java.io.Serializable;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 9:52 PM
 */
public class AccountGroup implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
