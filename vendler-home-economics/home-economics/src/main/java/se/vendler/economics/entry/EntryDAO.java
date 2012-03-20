package se.vendler.economics.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import se.vendler.economics.account.Account;
import se.vendler.economics.account.AccountImpl;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/7/12
 * Time: 10:33 PM
 */
@Repository
public class EntryDAO {
    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate getTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public void addEntry(Entry entry) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_text",entry.getText());
        source.addValue("p_account_id",entry.getAccount().getId());
        source.addValue("p_amount",entry.getAmount());
        source.addValue("p_date",entry.getDate());
        String sql = "call vhe.b_add_entry(:p_text,:p_account_id,:p_amount,:p_date)";
        getTemplate().update(sql,source);
    }

    public List<Entry> getAllEntries(String userId) {
        return getTemplate().query("call vhe.b_get_all_entries();",new MapSqlParameterSource(),new RowMapper<Entry>() {
            @Override
            public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountImpl account = new AccountImpl(rs.getString("acc_name"),rs.getString("acc_nr"),rs.getInt("acc_id"));
                return new Entry(
                        rs.getInt("entry_id"),
                        rs.getString("text"),
                        account,
                        rs.getDouble("amount"),
                        rs.getDate("date")
                );
            }
        });
    }
}
