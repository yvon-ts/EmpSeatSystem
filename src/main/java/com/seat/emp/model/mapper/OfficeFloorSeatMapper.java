package com.seat.emp.model.mapper;

import com.seat.emp.model.dto.OfficeFloorSeatDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OfficeFloorSeatMapper {
    List<OfficeFloorSeatDto> getOfficeFloorSeat(Integer officeId, Integer floorNo);
}
