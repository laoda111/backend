package com.template.springbootinitmaster.interfaces.controller.ailab;


import com.template.springbootinitmaster.application.AiResourceApplicationService;
import com.template.springbootinitmaster.infrastructure.common.core.domain.R;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.PageQuery;
import com.template.springbootinitmaster.infrastructure.common.mybatis.core.page.TableDataInfo;
import com.template.springbootinitmaster.interfaces.controller.BaseController;
import com.template.springbootinitmaster.interfaces.dto.AiResourceDto;
import com.template.springbootinitmaster.interfaces.vo.AiResourceVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/resource")
public class AiResourceController extends BaseController {


    private final AiResourceApplicationService aiResourceService;

    @GetMapping("/page")
    public R<TableDataInfo<AiResourceVo>> page(PageQuery pageQuery, AiResourceDto dto) {
        return R.ok(aiResourceService.listByPage(pageQuery, dto));
    }

    @GetMapping("/{id}")
    public R<AiResourceVo> getById(@PathVariable Long id) {
        return R.ok(aiResourceService.getById(id));
    }



}