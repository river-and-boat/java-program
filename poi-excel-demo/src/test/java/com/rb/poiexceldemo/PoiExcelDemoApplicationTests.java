package com.rb.poiexceldemo;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoiExcelDemoApplicationTests {

    @Test
    public void testSimpleRead() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("/Users/yuzhou.jiang/Desktop/Beach Study/java-program/poi-excel-demo/src/main/resources/student_info.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                CellType cellType = cell.getCellType();
                if (cellType == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + "\t");
                } else if (cellType == CellType.BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue() + "\t");
                } else if (cellType == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t");
                }
            }
            System.out.println("\n-----------------------------------");
        }
        System.out.println("\n====================================\n");
    }
}
