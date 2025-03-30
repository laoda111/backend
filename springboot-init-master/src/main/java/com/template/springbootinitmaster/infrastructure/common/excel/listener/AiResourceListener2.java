package com.template.springbootinitmaster.infrastructure.common.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.template.springbootinitmaster.application.AiResourceApplicationService;
import com.template.springbootinitmaster.domain.ailab.AiResource;
import com.template.springbootinitmaster.infrastructure.common.core.exception.ServiceException;
import com.template.springbootinitmaster.infrastructure.common.core.utils.SpringUtils;
import com.template.springbootinitmaster.infrastructure.common.core.utils.StringUtils;
import com.template.springbootinitmaster.infrastructure.common.excel.core.ExcelListener;
import com.template.springbootinitmaster.infrastructure.common.excel.core.ExcelResult;
import com.template.springbootinitmaster.interfaces.vo.AiResourceVo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

// 有个很重要的点 AiResourceListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class AiResourceListener2 extends AnalysisEventListener<AiResourceVo> implements ExcelListener<AiResourceVo> {

    private final StringBuilder successMsg = new StringBuilder();
    private final StringBuilder failureMsg = new StringBuilder();

    private int successNum = 0;
    private int failureNum = 0;


    private final AiResourceApplicationService aiResourceApplicationService;

    public AiResourceListener2() {
        this.aiResourceApplicationService = SpringUtils.getBean(AiResourceApplicationService.class);
    }



    @Override
    public ExcelResult<AiResourceVo> getExcelResult() {
        return null;
    }

    @Override
    public void invoke(AiResourceVo aiResourceVo, AnalysisContext analysisContext) {
        try {

            AiResource aiResource = new AiResource();
            aiResource.setType("大学学生实践资源");
            aiResource.setApplicableObjects("师范生");
            aiResource.setYear(aiResourceVo.getYear());
            aiResource.setDepartment(aiResourceVo.getDepartment());
            aiResource.setLanguage(aiResourceVo.getLanguage());
            aiResource.setDuration(aiResourceVo.getDuration());
            aiResource.setGrade(aiResourceVo.getGrade());
            aiResource.setEducationalStage(aiResourceVo.getEducationalStage());
            aiResource.setSubject(aiResourceVo.getSubject());
            aiResource.setWordType(aiResourceVo.getWordType());
            aiResource.setVideoResourceTypes(aiResourceVo.getVideoResourceTypes());
            aiResource.setResourceUrl(aiResourceVo.getResourceUrl());
            aiResource.setTextbook(aiResourceVo.getTextbook());
            aiResource.setLocation(aiResourceVo.getLocation());
            aiResource.setMedia(aiResourceVo.getMedia());
            aiResource.setDocument(aiResourceVo.getDocument());
            aiResource.setNation(aiResourceVo.getNation());
            aiResource.setTitle(getSub(aiResourceVo.getResourceUrl()));
            aiResource.setTeacherSex(aiResourceVo.getTeacherSex());
            aiResource.setTeachingFormat(aiResourceVo.getTeachingFormat());
            aiResource.setTeacherCategory(aiResourceVo.getTeacherCategory());
            aiResourceApplicationService.save(aiResource);

            successNum++;
            log.info("解析到一条数据:{}", JSON.toJSONString(aiResourceVo));
        } catch (Exception e) {
            failureMsg.append("<br/>" + "数据异常：" + JSON.toJSONString(aiResourceVo));
            failureNum++;
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 创建 ExcelResult 的匿名类实例
        ExcelResult<AiResourceVo> excelResult = new ExcelResult<>() {
            @Override
            public String getAnalysis() {
                if (failureNum > 0) {
                    failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
                    throw new ServiceException(failureMsg.toString());
                } else {
                    successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
                }
                return successMsg.toString();
            }

            @Override
            public List<String> getErrorList() {
                return null; // 根据需要返回错误列表
            }

            @Override
            public List<AiResourceVo> getList() {
                return null; // 根据需要返回 AiResourceVo 列表
            }
        };

        // 调用 exccelResult 的方法或处理结果
        String analysisResult = excelResult.getAnalysis();
        // 如果需要处理结果，可以在此进行
        log.info("分析结果: {}", analysisResult);
    }
    public String getSub(String resourceUrl){

        List<String>list =  StringUtils.splitList(resourceUrl,"\\");

        return list.get(list.size()-1);
    }
}