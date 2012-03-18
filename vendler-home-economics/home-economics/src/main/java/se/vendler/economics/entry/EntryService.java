package se.vendler.economics.entry;

import java.util.Date;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:51 PM
 */
public interface EntryService {
    List<Entry> addEntry(String text, String account, String amount, Date date);

    List<Entry> getEntries(String userId);

    List<Entry> extractEntries(String importString);
}
