package se.vendler.economics.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.vendler.economics.account.Account;
import se.vendler.economics.account.AccountService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] split1 = importString.split("\\n");
        List<Entry> entries = new ArrayList<Entry>();
        for (String s : split1) {

            String[] split = s.split("\\t");
            try {
                entries.add(new Entry(split[2],null,Double.valueOf(split[3].replace(",",".").replace(" ","")),simpleDateFormat.parse(split[1])));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<Account> accounts = accountService.getAccounts(1);

        for (Entry entry : entries) {
            entry.setAccount(entryDAO.getEntryBuyEntryText(entry.getText()));;
            if (entry.getAccount() == null) {
                entry.setAccount(accounts.get(0));
            }
        }
        return entries;
    }
}
