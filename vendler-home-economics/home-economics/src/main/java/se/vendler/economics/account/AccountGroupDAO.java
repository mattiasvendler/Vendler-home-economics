package se.vendler.economics.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/6/12
 * Time: 8:38 PM
 */
@Repository
public class AccountGroupDAO {

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate getTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public List<AccountGroup> getAccountGroups() {
        return getTemplate().query("call vhe.b_get_account_groups(null);",new MapSqlParameterSource(),new RowMapper<AccountGroup>() {
            @Override
            public AccountGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountGroupImpl accountGroup = new AccountGroupImpl();
                accountGroup.setId(rs.getInt("id"));
                accountGroup.setName(rs.getString("name"));
                return accountGroup;
            }
        });
    }
}
