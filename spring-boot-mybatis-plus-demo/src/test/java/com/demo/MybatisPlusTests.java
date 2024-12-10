package com.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.LLMFactory;
import com.demo.mapper.LLMFactoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MybatisPlusTests {

    @Resource
    private LLMFactoryMapper llmFactoryMapper;

    @Test
    public void testSelect() {
        List<LLMFactory> llmFactories = llmFactoryMapper.selectList(null);
        for (LLMFactory llmFactory : llmFactories) {
            System.out.println(llmFactory);
        }
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<LLMFactory> queryWrapper = new QueryWrapper<>();
        QueryWrapper<LLMFactory> query = queryWrapper.like("name", "G%");
        List<LLMFactory> llmFactories = llmFactoryMapper.selectList(query);
        for (LLMFactory llmFactory : llmFactories) {
            System.out.println(llmFactory);
        }
    }

    @Test
    public void testCustom() {
        List<LLMFactory> list = llmFactoryMapper.list();
        for (LLMFactory llmFactory : list) {
            System.out.println(llmFactory);
        }
    }

    @Test
    public void testPage() {
        Page<LLMFactory> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        Page<LLMFactory> list = llmFactoryMapper.page(page);
        System.out.println(list);
    }
}
