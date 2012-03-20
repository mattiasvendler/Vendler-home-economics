package se.vendler.webclient.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.stereotype.Controller;
import se.vendler.webclient.client.ClientController;

import javax.servlet.http.HttpSession;

/**
 * User: Mattias Vendler
 * Date: 2/29/12
 * Time: 10:11 PM
 */
public class ClientControllerImpl extends RemoteServiceServlet implements ClientController {
    @Override
    public Boolean isUserLoggedIn() {
        HttpSession session = getThreadLocalRequest().getSession(false);
        if (session == null) {
            return false;
        }
        return session.getAttribute("userId") != null;
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