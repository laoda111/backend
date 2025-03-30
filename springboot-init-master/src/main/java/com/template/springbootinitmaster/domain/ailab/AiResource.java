package com.template.springbootinitmaster.domain.ailab;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 * @TableName ai_resource
 */
@TableName(value ="ai_resource")
@Data
public class AiResource {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 授课学段
     */
    private String educationalStage;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学科
     */
    private String subject;

    /**
     * 教师性别
     */
    private String teacherSex;

    /**
     * 授课形式
     */
    private String teachingFormat;

    /**
     * 教师类型
     */
    private String teacherCategory;

    /**
     * 教材
     */
    private String textbook;

    /**
     * 授课时长
     */
    private String duration;

    /**
     * 授课地点
     */
    private String location;

    /**
     * 媒体使用
     */
    private String media;

    /**
     * 教学文档
     */
    private String document;

    /**
     * 资源路径
     */
    private String resourceUrl;

    /**
     * 院系
     */
    private String department;

    /**
     * 实践资源类型
     */
    private String wordType;

    /**
     * 数据年份
     */
    private String year;

    /**
     * 适用对象
     */
    private String applicableObjects;

    /**
     * 国别
     */
    private String nation;

    /**
     * 语言
     */
    private String language;


    /**
     * 标题
     */
    private String title;

    /**
     * 视频资源类型
     */
    private String VideoResourceTypes;


}
