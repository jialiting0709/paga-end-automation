package com.paga.data;
import org.testng.annotations.DataProvider;

import com.paga.util.ReadExcel;

public class TestDataFactory {
    /*
     * Parameterized test data class
     */
    @DataProvider(name="TestData")
    public static Object[][] getTestData(){
        return ReadExcel.getDataFromExcel("BaiDuQueryTest.xlsx", "query");
    }

}
