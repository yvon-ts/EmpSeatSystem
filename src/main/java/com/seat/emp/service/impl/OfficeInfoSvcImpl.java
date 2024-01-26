package com.seat.emp.service.impl;

import com.seat.emp.model.dto.OfficeFloorSeatDto;
import com.seat.emp.model.mapper.SeatMapper;
import com.seat.emp.service.OfficeInfoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeInfoSvcImpl implements OfficeInfoSvc {
    @Autowired
    private SeatMapper seatMapper;
    @Override
    public List<OfficeFloorSeatDto> getOffice() {
        return seatMapper.getOfficeFloorInfo(null, null);
    }
}
