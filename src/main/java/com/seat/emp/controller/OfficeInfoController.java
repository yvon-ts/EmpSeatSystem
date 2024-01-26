package com.seat.emp.controller;

import com.seat.emp.common.Result;
import com.seat.emp.service.OfficeInfoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeInfoController {

    @Autowired
    private OfficeInfoSvc officeInfoSvc;

    @GetMapping("/offices")
    public Result getOffices(){
        officeInfoSvc.getOffice();
        return Result.success(officeInfoSvc.getOffice());
    }
}
