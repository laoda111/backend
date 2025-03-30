package com.template.springbootinitmaster.interfaces.vo;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AiResourceVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;


    @ExcelProperty(value = "文档类型")
    private String type;

    @ExcelProperty(value = "授课学段")
    private String grade;

    @ExcelProperty(value = "年级")
    private String gradeLevel;

    @ExcelProperty(value = "授课学科")
    private String subject;

    @ExcelProperty(value = "授课老师")
    private String teacher;

    @ExcelProperty(value = "教师性别")
    private String teacherSex;

    @ExcelProperty(value = "年龄")
    private String age;

    @ExcelProperty(value = "授课形式")
    private String teachingFormat;

    @ExcelProperty(value = "教师类型")
    private String teachingType;

    @ExcelProperty(value = "名师特色信息")
    private String feacture;

    @ExcelProperty(value = "授课时长")
    private String duration;

    



}
