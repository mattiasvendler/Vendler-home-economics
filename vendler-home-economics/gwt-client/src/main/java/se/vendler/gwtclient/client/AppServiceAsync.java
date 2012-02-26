package se.vendler.gwtclient.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface AppServiceAsync {
    void test(String s,AsyncCallback<String> async);

    void getSomething(AsyncCallback<String> async);

    public static final class Util
    {
        private static AppServiceAsync instance;

        public static final AppServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (AppServiceAsync) GWT.create(AppService.class);
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "AppService" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
