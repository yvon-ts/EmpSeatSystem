package com.seat.emp.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Department {
    @TableId(value = "dept_id")
    private Integer id;

    @TableField(value = "dept_name")
    private String name;
}
