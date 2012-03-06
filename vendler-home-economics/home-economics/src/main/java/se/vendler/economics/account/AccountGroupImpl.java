package se.vendler.economics.account;

/**
 * User: Mattias Vendler
 * Date: 3/6/12
 * Time: 8:37 PM
 */
public class AccountGroupImpl implements AccountGroup {
    private Integer id;
    private String name;

    public AccountGroupImpl() {
    }

    public AccountGroupImpl(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
