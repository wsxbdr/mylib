package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.LLMFactory;

import java.util.List;

public interface LLMFactoryMapper extends BaseMapper<LLMFactory> {

    List<LLMFactory> list();

    Page<LLMFactory> page(Page page);
}
