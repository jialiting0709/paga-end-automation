package com.paga;

import com.google.common.collect.Lists;
import org.testng.TestNG;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        TestNG tng = new TestNG();
        List<String> suites = Lists.newArrayList();
        //Get project root path
        String root = System.getProperty("user.dir");
        suites.add(root+"/src/main/resources/testng.xml");
        tng.setTestSuites(suites);
        tng.run();
    }
}
