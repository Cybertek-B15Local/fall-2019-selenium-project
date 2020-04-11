package com.cybertek.tests.day19_excel_io;


import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilityDemo {
    private String filePath = "src/test/resources/Vytrack testusers.xlsx";
    private String sheetName = "QA3-short";
    @Test
    public void test() {

        ExcelUtil qa3Short = new ExcelUtil(filePath, sheetName);
        System.out.println(qa3Short.getColumnsNames());

        String data [][] = qa3Short.getDataArray();
        List<Map<String, String>> dataList = qa3Short.getDataList();
        System.out.println(dataList);
    }
}
