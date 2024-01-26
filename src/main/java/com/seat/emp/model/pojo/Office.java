package com.seat.emp.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Office {
    @TableId(value = "office_id")
    private Integer id;

    @TableField(value = "office_name")
    private String name;
}
