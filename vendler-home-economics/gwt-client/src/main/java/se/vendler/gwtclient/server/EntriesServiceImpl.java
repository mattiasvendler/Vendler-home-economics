package se.vendler.gwtclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.gwtclient.client.EntriesService;

import java.util.Arrays;
import java.util.List;

/**
 * User: Mattias Vendler
 * Date: 2/24/12
 * Time: 10:27 PM
 */
public class EntriesServiceImpl extends RemoteServiceServlet implements EntriesService {
    @Override
    public String[] getSuggestion(String text) {
        return new String[]{"Mat inköp","Lön Mattias"};
    }

    @Override
    public List<String> getAccounts() {
        String[] accounts = new String[]{"Mat","Boende","Bil","Nöje"};
        return Arrays.asList(accounts);
    }
}
