package se.vendler.gwtclient.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by IntelliJ IDEA.
 * User: mattias
 * Date: 2/22/12
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
@RemoteServiceRelativePath("AppService")
public interface AppService extends RemoteService{
    String test(String s);
    String getSomething();
}
