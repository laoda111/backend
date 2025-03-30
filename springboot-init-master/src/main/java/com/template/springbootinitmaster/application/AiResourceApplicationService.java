package com.template.springbootinitmaster.application;

import com.baomidou.mybatisplus.extension.service.IService;
import com.template.springbootinitmaster.domain.ailab.AiResource;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.PageQuery;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.TableDataInfo;
import com.template.springbootinitmaster.interfaces.dto.AiResourceDto;
import com.template.springbootinitmaster.interfaces.vo.AiResourceVo;

public interface AiResourceApplicationService extends IService<AiResource> {


    TableDataInfo<AiResourceVo> listByPage(PageQuery pageQuery, AiResourceDto aiResourceDto);

    AiResourceVo getById(Long id);
}
