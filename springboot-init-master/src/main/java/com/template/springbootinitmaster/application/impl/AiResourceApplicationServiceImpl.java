package com.template.springbootinitmaster.application.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.template.springbootinitmaster.application.AiResourceApplicationService;
import com.template.springbootinitmaster.domain.ailab.AiResource;
import com.template.springbootinitmaster.domain.mapper.AiResourceMapper;
import com.template.springbootinitmaster.infrastructure.common.core.utils.StringUtils;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.PageQuery;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.TableDataInfo;
import com.template.springbootinitmaster.interfaces.dto.AiResourceDto;
import com.template.springbootinitmaster.interfaces.vo.AiResourceVo;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class AiResourceApplicationServiceImpl extends ServiceImpl<AiResourceMapper, AiResource> implements AiResourceApplicationService {


    @Resource
    private  AiResourceMapper aiResourceMapper;



    @Override
    public TableDataInfo<AiResourceVo> listByPage(PageQuery pageQuery, AiResourceDto aiResourceDto) {
        Page<AiResourceVo> result = aiResourceMapper.selectVoPage(pageQuery.build(), buildQueryWrapper(aiResourceDto));
        return TableDataInfo.build(result);
    }

    @Override
    public AiResourceVo getById(Long id) {
        return aiResourceMapper.selectVoById(id);
    }


    private LambdaQueryWrapper<AiResource> buildQueryWrapper(AiResourceDto dto) {
        LambdaQueryWrapper<AiResource> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(dto.getTitle()), AiResource::getTitle, dto.getTitle());
        lqw.like(StringUtils.isNotBlank(dto.getType()), AiResource::getType, dto.getType());
        lqw.like(StringUtils.isNotBlank(dto.getSubject()), AiResource::getSubject, dto.getSubject());
        lqw.like(StringUtils.isNotBlank(dto.getApplicableObjects()), AiResource::getApplicableObjects, dto.getApplicableObjects());
        lqw.like(StringUtils.isNotBlank(dto.getGrade()), AiResource::getGrade, dto.getGrade());
        return lqw;
    }



}
