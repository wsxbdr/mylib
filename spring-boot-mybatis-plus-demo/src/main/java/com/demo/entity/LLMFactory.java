package com.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("llm_factories")
public class LLMFactory {
    private String name;

    private String logo;

    private String tags;

    private Boolean status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Long updateTime;

    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;
}
