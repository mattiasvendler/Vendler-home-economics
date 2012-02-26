package se.vendler.gwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * User: mattias
 * Date: 2/23/12
 * Time: 9:51 PM
 */
public class TableTest implements EntryPoint {
    private static class SimpleClass {
        private final String a;
        private final String b;

        private SimpleClass(String a, String b) {
            this.a = a;
            this.b = b;
        }

    }
    private static List<SimpleClass> simpleClasses = Arrays.asList(new SimpleClass("a", "b"), new SimpleClass("aa", "bb"));

    @Override
    public void onModuleLoad() {
        CellTable<SimpleClass> table = new CellTable<SimpleClass>();
        TextColumn<SimpleClass> aCell = new TextColumn<SimpleClass>() {

            @Override
            public String getValue(SimpleClass object) {
                return object.a;
            }
        };
        TextColumn<SimpleClass> bCell = new TextColumn<SimpleClass>() {

            @Override
            public String getValue(SimpleClass object) {
                return object.b;
            }
        };
        table.addColumn(aCell,"A");
        table.addColumn(bCell,"B");
        ListDataProvider<SimpleClass> listDataProvider = new ListDataProvider<SimpleClass>();
        listDataProvider.addDataDisplay(table);
        List<SimpleClass> simpleClassList = listDataProvider.getList();
        for (SimpleClass simpleClass : simpleClasses) {
            simpleClassList.add(simpleClass);
        }
        RootPanel.get("testTable").add(table);

    }
}
