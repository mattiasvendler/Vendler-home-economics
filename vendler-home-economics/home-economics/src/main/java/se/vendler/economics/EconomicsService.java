package se.vendler.economics;

import se.vendler.economics.account.AccountService;
import se.vendler.economics.entry.Entry;
import se.vendler.economics.entry.EntryService;

import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:50 PM
 */
public interface EconomicsService extends AccountService,EntryService{
}
