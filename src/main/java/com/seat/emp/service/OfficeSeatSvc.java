package com.seat.emp.service;

import com.seat.emp.model.dto.OfficeFloorSeatDto;
import com.seat.emp.model.dto.DeptDto;

import java.util.List;

public interface OfficeSeatSvc {
    List<OfficeFloorSeatDto> getOffices();

    List<OfficeFloorSeatDto> getFloorsByOffice(Integer officeId);

    List<OfficeFloorSeatDto> getSeatsByFloor(Integer officeId, Integer floorNo);

    List<DeptDto> getDepts();

    List<DeptDto> getEmpsByDept(Integer deptId);
}
