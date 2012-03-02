package se.vendler.gwtclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.gwtclient.client.ClientController;

import javax.servlet.http.HttpSession;

/**
 * User: Mattias Vendler
 * Date: 2/29/12
 * Time: 10:11 PM
 */
public class ClientControllerImpl extends RemoteServiceServlet implements ClientController {
    @Override
    public Boolean isUserLoggedIn() {
        HttpSession session = getThreadLocalRequest().getSession();
        if (session == null) {
            return false;
        }
        if (session.getAttribute("userId") != null) {
          return true;
        }
        return false;
    }

    @Override
    public Boolean login(String userName, String password) {
        HttpSession session = getThreadLocalRequest().getSession(true);
        session.setAttribute("username",userName);
        session.setAttribute("password",password);
        session.setAttribute("userId",1);
        return true;
    }


}