package com.nopcommerce.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelUtils {
    private String filePath;
    private Workbook workbook;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getRowData(String sheetName, int rowNum) {
        Map<String, String> data = new LinkedHashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return data;
        Row header = sheet.getRow(0);
        Row row = sheet.getRow(rowNum);
        if (row == null) return data;
        Iterator<Cell> cellIterator = row.cellIterator();
        int idx = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String key = header.getCell(idx).getStringCellValue();
            String value = "";
            if (cell.getCellType() == CellType.STRING) value = cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC) value = String.valueOf((int)cell.getNumericCellValue());
            data.put(key, value);
            idx++;
        }
        return data;
    }
}
