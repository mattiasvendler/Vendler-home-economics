package se.vendler.client.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import se.vendler.client.client.AppService;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 2/22/12
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppServiceImpl extends RemoteServiceServlet implements AppService{
    @Override
    public String test() {
        return "hej";
    }
}
