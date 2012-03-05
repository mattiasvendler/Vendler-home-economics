package se.vendler.economics.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:42 PM
 */
@Repository
public class AccountDAO {

    private List<Account> accounts;
    @Autowired
    private DataSource dataSource;

    @Autowired
    public NamedParameterJdbcTemplate getTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Account> getAccounts() {
        return getTemplate().query("call q_get_all_accounts();",new MapSqlParameterSource(),new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new AccountImpl();
                account.setAccountName(rs.getString("name"));
                account.setAccountNumber(rs.getString("account_nr"));
                return account;
            }
        });
    }
}
