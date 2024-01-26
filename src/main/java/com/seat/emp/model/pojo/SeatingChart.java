package com.seat.emp.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SeatingChart extends BasePojo {

    @TableId(value = "floor_seat_seq")
    private Integer id;

    private Integer floorNo;

    private Integer seatNo;

    private Integer officeId;
}
