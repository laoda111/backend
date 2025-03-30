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
    private String feature;

    @ExcelProperty(value = "授课时长")
    private String duration;

    @ExcelProperty(value = "其他视频资源类型")
    private String VideoResourceTypes;

    @ExcelProperty(value = "路径")
    private String resourceUrl;

    @ExcelProperty(value = "教材")
    private String textbook;

    @ExcelProperty(value = "授课地点")
    private String location;

    @ExcelProperty(value = "媒体使用")
    private String media;

    @ExcelProperty(value = "教学文档")
    private String document;
}
