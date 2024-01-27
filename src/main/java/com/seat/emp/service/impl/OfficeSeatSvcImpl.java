package com.seat.emp.service.impl;

import com.seat.emp.model.dto.DeptDto;
import com.seat.emp.model.dto.OfficeFloorSeatDto;
import com.seat.emp.model.mapper.DeptMapper;
import com.seat.emp.model.mapper.OfficeFloorSeatMapper;
import com.seat.emp.service.OfficeSeatSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeSeatSvcImpl implements OfficeSeatSvc {
    @Autowired
    private OfficeFloorSeatMapper officeFloorSeatMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<OfficeFloorSeatDto> getOffices() {
        return officeFloorSeatMapper.getOfficeFloorSeat(null, null);
    }

    @Override
    public List<OfficeFloorSeatDto> getFloorsByOffice(Integer officeId) {
        return officeFloorSeatMapper.getOfficeFloorSeat(officeId, null);
    }

    @Override
    public List<OfficeFloorSeatDto> getSeatsByFloor(Integer officeId, Integer floorNo) {
        return officeFloorSeatMapper.getOfficeFloorSeat(officeId, floorNo);
    }

    @Override
    public List<DeptDto> getDepts() {
        return deptMapper.getDeptInfo(null);
    }

    @Override
    public List<DeptDto> getEmpsByDept(Integer deptId) {
        return deptMapper.getDeptInfo(deptId);
    }

}
