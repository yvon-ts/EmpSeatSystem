package com.seat.emp.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seat.emp.model.dto.OfficeFloorSeatDto;
import com.seat.emp.model.pojo.SeatingChart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SeatMapper extends BaseMapper<SeatingChart> {
    List<OfficeFloorSeatDto> getOfficeFloorInfo(Integer officeId, Integer floorNo);
}
