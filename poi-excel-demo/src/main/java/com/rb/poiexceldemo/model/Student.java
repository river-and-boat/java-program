package com.rb.poiexceldemo.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;

    @ExcelAttribute(sort = 0, value = "姓名")
    private String name;

    @ExcelAttribute(sort = 1, value = "年龄")
    private Integer age;

    @ExcelAttribute(sort = 2, value = "住址")
    private String address;

    @ExcelAttribute(sort = 3, value = "生日")
    private Date birthday;

    @ExcelAttribute(sort = 4, value = "身高")
    private Double height;

    @ExcelAttribute(sort = 5, value = "是否来自大陆")
    private Boolean isMainlandChina;
}
