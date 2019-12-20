package com.paga.data;
import org.testng.annotations.DataProvider;

import com.paga.util.ReadExcel;

public class TestDataFactory {
    /*
     * 参数化测试数据类
     */
    @DataProvider(name="TestData")
    public static Object[][] getTestData(){
        return ReadExcel.getDataFromExcel("BaiDuQueryTest.xlsx", "query");
    }

}
