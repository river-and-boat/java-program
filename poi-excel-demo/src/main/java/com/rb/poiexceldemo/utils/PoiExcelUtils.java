package com.rb.poiexceldemo.utils;

import com.rb.poiexceldemo.model.ExcelAttribute;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExcelUtils<T> {
    private Class<T> clazz;

    private Map<Integer, Field> fieldMap = new HashMap<>();

    public PoiExcelUtils(Class<T> clazz) {
        this.clazz = clazz;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelAttribute.class)) {
                fieldMap.put(field.getAnnotation(ExcelAttribute.class).sort(), field);
            }
        }
    }

    public void exportExcelWithTemplate(List<T> dataList, String excelName, InputStream in, Integer rowIndex,
                                        Integer cellIndex, HttpServletResponse response)
            throws IOException, IllegalAccessException {
        XSSFWorkbook workbook = mapData2ExcelWithTemplate(dataList, in, rowIndex, cellIndex);
        String fileName = new String(excelName.getBytes("UTF-8"), "ISO-8859-1");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        response.setHeader("filename", fileName);
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    public void exportExcelToLocalWithTemplate(List<T> dataList, InputStream is, String pathName, Integer rowIndex, Integer cellIndex) throws IOException, IllegalAccessException {
        // 把数据封装到Excel
        XSSFWorkbook workbook = mapData2ExcelWithTemplate(dataList, is, rowIndex, cellIndex);
        //===============导出Excel到本地=================
        FileOutputStream fileOutputStream = new FileOutputStream(pathName);
        workbook.write(fileOutputStream);
    }

    public void exportExcel(List<T> dataList, String excelName, String sheetName, HttpServletResponse response) throws IllegalAccessException, IOException {
        XSSFWorkbook workbook = mapData2Excel(dataList, sheetName);

        //===============response响应导出Excel=================
        String fileName = new String(excelName.getBytes("UTF-8"), "ISO-8859-1");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        response.setHeader("filename", fileName);
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    public void exportExcelToLocal(List<T> dataList, String pathName, String sheetName) throws IllegalAccessException, IOException {
        XSSFWorkbook workbook = mapData2Excel(dataList, sheetName);

        //===============导出Excel到本地=================
        FileOutputStream fileOutputStream = new FileOutputStream(pathName);
        workbook.write(fileOutputStream);
    }

    public List<T> importExcel(InputStream inputStream, Integer rowIndex, Integer cellIndex)
            throws IOException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, ParseException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<T> dataList = new ArrayList<>();

        for (int i = rowIndex; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            T pojo = clazz.getDeclaredConstructor().newInstance();
            for (int j = cellIndex; j < row.getLastCellNum(); j++) {
                XSSFCell cell = row.getCell(j);
                Field field = fieldMap.get(j - cellIndex);
                field.setAccessible(true);
                field.set(pojo, convertAttrType(field, cell));
            }
            dataList.add(pojo);
        }
        return dataList;
    }

    private XSSFWorkbook mapData2Excel(List<T> dataList, String sheetName) throws IllegalAccessException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 创建表头
        XSSFRow row = sheet.createRow(0);
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(ExcelAttribute.class)) {
                row.createCell(i).setCellValue(field.getAnnotation(ExcelAttribute.class).value());
            }
        }
        // 设置数据
        int size = fieldMap.keySet().size();
        for (int i = 0, length = dataList.size(); i < length; i++) {
            T pojo = dataList.get(i);
            row = sheet.createRow(i + 1);
            for (int k = 0; k < size; k++) {
                XSSFCell cell = row.createCell(k);
                Field field = fieldMap.get(k);
                field.setAccessible(true);
                mappingValue(field, cell, pojo);
            }
        }
        return workbook;
    }

    private XSSFWorkbook mapData2ExcelWithTemplate(List<T> dataList, InputStream in,
                                                   Integer rowIndex, Integer cellIndex) throws IOException, IllegalAccessException {
        // 得到模版
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // 抽取模版样式
        CellStyle[] templateStyles = getTemplateStyles(rowIndex, cellIndex, sheet);

        // 创建单元格，并设置样式和数据
        for (int i = 0; i < dataList.size(); i++) {
            T pojo = dataList.get(i);
            XSSFRow row = sheet.createRow(i + rowIndex);
            for (int k = cellIndex; k < templateStyles.length + cellIndex; k++) {
                XSSFCell cell = row.createCell(k);
                cell.setCellStyle(templateStyles[k - cellIndex]);
                Field field = fieldMap.get(k - cellIndex);
                field.setAccessible(true);
                mappingValue(field, cell, pojo);
            }
        }
        return workbook;
    }

    private void mappingValue(Field field, Cell cell, Object pojo) throws IllegalAccessException {
        Class<?> fieldType = field.getType();
        if (Date.class.isAssignableFrom(fieldType)) {
            cell.setCellValue((Date) field.get(pojo));
        } else if (int.class.isAssignableFrom(fieldType) || Integer.class.isAssignableFrom(fieldType)) {
            cell.setCellValue((Integer) field.get(pojo));
        } else if (double.class.isAssignableFrom(fieldType) || Double.class.isAssignableFrom(fieldType)) {
            cell.setCellValue((Double) field.get(pojo));
        } else if (boolean.class.isAssignableFrom(fieldType) || Boolean.class.isAssignableFrom(fieldType)) {
            cell.setCellValue((Boolean) field.get(pojo));
        } else if (BigDecimal.class.isAssignableFrom(fieldType)) {
            cell.setCellValue(((BigDecimal) field.get(pojo)).doubleValue());
        } else {
            cell.setCellValue((String) field.get(pojo));
        }
    }

    private CellStyle[] getTemplateStyles(Integer rowIndex, Integer cellIndex, XSSFSheet sheet) {
        XSSFRow dataTemplateRow = sheet.getRow(rowIndex);
        CellStyle[] cellStyles = new CellStyle[dataTemplateRow.getLastCellNum() - cellIndex];
        for (int i = 0; i < cellStyles.length; i++) {
            cellStyles[i] = dataTemplateRow.getCell(i + cellIndex).getCellStyle();
        }
        return cellStyles;
    }

    // 将String类型统一转换为对象具体类型
    private Object convertAttrType(Field field, Cell cell) throws ParseException {
        Class<?> fieldType = field.getType();
        if (String.class.isAssignableFrom(fieldType)) {
            return getValue(cell);
        } else if (Date.class.isAssignableFrom(fieldType)) {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(getValue(cell));
        } else if (int.class.isAssignableFrom(fieldType) || Integer.class.isAssignableFrom(fieldType)) {
            return Integer.parseInt(getValue(cell));
        } else if (double.class.isAssignableFrom(fieldType) || Double.class.isAssignableFrom(fieldType)) {
            return Double.parseDouble(getValue(cell));
        } else if (boolean.class.isAssignableFrom(fieldType) || Boolean.class.isAssignableFrom(fieldType)) {
            return Boolean.valueOf(getValue(cell));
        } else if (BigDecimal.class.isAssignableFrom(fieldType)) {
            return new BigDecimal(getValue(cell));
        } else {
            return null;
        }
    }

    // 将cell的值转换为String类型
    private String getValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getRichStringCellValue().getString().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date javaDate = DateUtil.getJavaDate(cell.getNumericCellValue());
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(javaDate);
                } else {
                    String cellStr = "";
                    double num = cell.getNumericCellValue();
                    BigDecimal bd = new BigDecimal(Double.toString(num));
                    cellStr = bd.toPlainString();
                    if (cellStr.endsWith(".0")) {
                        cellStr = cellStr.substring(0, cellStr.indexOf("."));
                    }
                    return cellStr;
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
