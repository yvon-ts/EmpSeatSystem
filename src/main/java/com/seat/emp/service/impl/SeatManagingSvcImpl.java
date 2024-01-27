package com.seat.emp.service.impl;

import com.seat.emp.model.dto.DeptDto;
import com.seat.emp.model.dto.OfficeFloorSeatDto;
import com.seat.emp.model.mapper.DeptMapper;
import com.seat.emp.model.mapper.SeatManagingMapper;
import com.seat.emp.service.SeatManagingSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatManagingSvcImpl implements SeatManagingSvc {
    @Autowired
    private SeatManagingMapper seatManagingMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<OfficeFloorSeatDto> getOffices() {
        return seatManagingMapper.getOfficeFloorSeat(null, null);
    }

    @Override
    public List<OfficeFloorSeatDto> getFloorsByOffice(Integer officeId) {
        return seatManagingMapper.getOfficeFloorSeat(officeId, null);
    }

    @Override
    public List<OfficeFloorSeatDto> getSeatsByFloor(Integer officeId, Integer floorNo) {
        return seatManagingMapper.getOfficeFloorSeat(officeId, floorNo);
    }

    @Override
    public List<DeptDto> getDepts() {
        return deptMapper.getDeptInfo(null);
    }

    @Override
    public List<DeptDto> getEmpsByDept(Integer deptId) {
        return deptMapper.getDeptInfo(deptId);
    }

    @Override
    public void updateEmpSeat(Integer flagChange, Integer floorSeatSeq, Integer empId) {
        seatManagingMapper.updateEmpSeat(flagChange, floorSeatSeq, empId);
    }

}
