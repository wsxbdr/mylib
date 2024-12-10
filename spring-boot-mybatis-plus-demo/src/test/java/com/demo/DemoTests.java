package com.demo;

import com.demo.entity.Demo;
import com.demo.mapper.DemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class DemoTests {

    @Resource
    private DemoMapper demoMapper;

    @Test
    public void save() {
        Demo demo = new Demo();
        demo.setNum(2);
        demo.setName("zs");

        int insert = demoMapper.insert(demo);
        System.out.println(insert);
    }

    @Test
    public void update() {
        Demo demo = new Demo();
        demo.setId("f3f1c976f483017ae1a1c509a5cffd50");
        demo.setNum(12);
        demo.setName("ls");
        demo.setVersion(2);
        int i = demoMapper.updateById(demo);
        System.out.println(i);
    }

    @Test
    public void query(){
        List<Demo> list = demoMapper.selectList(null);
        for (Demo demo : list) {
            System.out.println(demo);
        }
    }

}
