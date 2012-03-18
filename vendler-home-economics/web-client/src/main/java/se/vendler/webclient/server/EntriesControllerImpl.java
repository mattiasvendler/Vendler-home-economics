package se.vendler.webclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.economics.EconomicsService;
import se.vendler.economics.entry.EntryService;
import se.vendler.economics.util.spring.BeanLocator;
import se.vendler.webclient.client.EntriesController;
import se.vendler.webclient.client.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/28/12
 * Time: 1:32 PM
 */
public class EntriesControllerImpl extends RemoteServiceServlet implements EntriesController {
    private static List<Entry> entries = new ArrayList<Entry>();
    private EntryService entryService;
    public EntriesControllerImpl() {
        entryService= BeanLocator.getBean(EntryService.class);
    }

    @Override
    public void addEntry(Entry entry) {
        entryService.addEntry(entry.getText(), entry.getAccount(), entry.getAmount(), entry.getDate());
    }

    @Override
    public List<Entry> getAllEntries(String userId) {
        List<se.vendler.economics.entry.Entry> entries = entryService.getEntries(userId);
        List<Entry> entriesList = transformEntries(entries);
        return entriesList;
    }

    private List<Entry> transformEntries(List<se.vendler.economics.entry.Entry> entries) {
        List<Entry> entriesList = new ArrayList<Entry>();
        for (se.vendler.economics.entry.Entry entry : entries) {
            Entry e = new Entry(entry.getId()+"",entry.getText(),entry.getAccount().getAccountName(),entry.getAmount().toString(),entry.getDate());
            entriesList.add(e);
        }
        return entriesList;
    }

    @Override
    public List<Entry> importEntries(String importString) {
        List<se.vendler.economics.entry.Entry> entries = entryService.extractEntries(importString);
        return transformEntries(entries);
    }
}