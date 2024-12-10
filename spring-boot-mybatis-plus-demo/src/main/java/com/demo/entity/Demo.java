package com.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("demo")
public class Demo {

    @TableId
    private String id;

    private String name;

    private Integer num;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Long updateTime;

    @TableLogic
    private Boolean deleted = Boolean.FALSE;

    @Version
    private Integer version;

    private Long tenantId;
}
