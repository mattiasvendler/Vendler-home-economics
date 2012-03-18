package se.vendler.economics.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.vendler.economics.account.Account;
import se.vendler.economics.account.AccountService;

import java.util.Date;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/7/12
 * Time: 8:46 PM
 */
@Component
public class EntryServiceImpl implements EntryService{
    @Autowired
    private AccountService accountService;
    @Autowired
    private EntryDAO entryDAO;
    @Override
    public List<Entry> addEntry(String text, String accountNr, String amount, Date date) {
        Account account = accountService.getAccount(accountNr);
        Entry entry = new Entry(text,account,Double.valueOf(amount),date);
        entryDAO.addEntry(entry);
        return null;
    }

    @Override
    public List<Entry> getEntries(String userId) {
        return entryDAO.getAllEntries(userId);
    }

    @Override
    public List<Entry> extractEntries(String importString) {
        String[] split1 = importString.split("\\n");
        for (String s : split1) {

            String[] split = s.split("\\t");
            int i  = split.length;
        }
        return null;
    }
}
