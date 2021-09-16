package com.rb.poiexceldemo.controller;

import com.rb.poiexceldemo.model.Student;
import com.rb.poiexceldemo.utils.PoiExcelUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response)
            throws IOException, IllegalAccessException, ParseException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "周深（web导出）", 28, "贵州", new SimpleDateFormat("yyyy-MM-dd").parse("1992-9-29"), 161.0, true));
        studentList.add(new Student(2L, "李健（web导出）", 46, "哈尔滨", new SimpleDateFormat("yyyy-MM-dd").parse("1974-9-23"), 174.5, true));
        studentList.add(new Student(3L, "周星驰（web导出）", 58, "香港", new SimpleDateFormat("yyyy-MM-dd").parse("1962-6-22"), 174.0, false));

        // 导出数据
        PoiExcelUtils<Student> poiExcelUtils = new PoiExcelUtils<>(Student.class);
        FileInputStream excelTemplateInputStream = new FileInputStream(new File("/Users/yuzhou.jiang/Desktop/Beach Study/java-program/poi-excel-demo/src/main/resources/student_info.xlsx"));
        poiExcelUtils.exportExcelWithTemplate(studentList, "学生信息表.xlsx", excelTemplateInputStream, 2, 0, response);
    }

    @PostMapping("/importExcel")
    public Map<String, Object> importExcel(MultipartFile file) throws Exception {
        PoiExcelUtils<Student> poiExcelUtils = new PoiExcelUtils<>(Student.class);
        List<Student> studentList = poiExcelUtils.importExcel(file.getInputStream(), 2, 0);

        saveToDB(studentList);
        System.out.println("导入" + file.getOriginalFilename() + "成功!");

        // 这里用Map偷懒了，实际项目中可以封装Result实体类返回
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", studentList);
        result.put("msg", "success");
        return result;


    }

    private void saveToDB(List<Student> studentList) {
        if (CollectionUtils.isEmpty(studentList)) {
            return;
        }
        // 直接打印，模拟插入数据库
        studentList.forEach(System.out::println);
    }
}
