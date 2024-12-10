package com.demo;

import com.demo.entity.LLMFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
public class MysqlTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQuery() {
        String sql = "select * from llm_factories";

        List<LLMFactory> lfs = jdbcTemplate.query(sql, (resultSet, i) -> {
            LLMFactory lf = new LLMFactory();
            lf.setName(resultSet.getString("name"));
            lf.setLogo(resultSet.getString("logo"));
            lf.setTags(resultSet.getString("tags"));
            lf.setStatus(resultSet.getBoolean("status"));
            lf.setCreateTime(resultSet.getLong("create_time"));
            lf.setCreateDate(resultSet.getDate("create_date"));
            lf.setUpdateTime(resultSet.getLong("update_time"));
            lf.setUpdateDate(resultSet.getDate("update_date"));
            return lf;
        });

        for (LLMFactory lf : lfs) {
            System.out.println(lf);
        }
    }
}
