package com.seat.emp.model.mapper;

import com.seat.emp.model.dto.DeptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<DeptDto> getDeptInfo(Integer deptId);
}
