package com.app.utils;

import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderTDD {

    // Hard coded data provider with String object
    @DataProvider(name = "searchData", parallel = true)
    public String[][] searchMethod() {
        return new String[][]{
                {"Sri Harshavardhan"},
                {"Vimala Devi"}
        };
    }

    // Hard coded data provider method with Iterator
    @DataProvider(name = "searchDataWithIterator", parallel = true)
    public Iterator<String> searchMethodWithIterator() {
        List<String> s = new ArrayList<>();
        s.add("Barack Obama");
        s.add("George Bush");
        return s.iterator();
    }

    // Hard coded data provider with general object return type
    @DataProvider(name = "searchDataWithObject", parallel = true)
    public Object[][] searchMethodByObject() {
        Object data[][] = new Object[][]{
                {"Neelima"},
                {"Bill Gates"}
        };
        return data;
    }
}
