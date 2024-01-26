package com.seat.emp.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class Employee extends BasePojo {

    @TableId(value = "emp_id")
    private Integer id;

    @TableField(value = "emp_name")
    private String name;

    @Email
    private String email;

    private Integer deptId;

    private Integer floorSeatSeq;
}
