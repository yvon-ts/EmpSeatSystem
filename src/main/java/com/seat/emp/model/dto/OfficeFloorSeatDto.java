package com.seat.emp.model.dto;

import lombok.Data;

@Data
public class OfficeFloorSeatDto {

    private Integer officeId;

    private String officeName;

    private Integer floorNo;

    private Integer seatNo;

    private Integer state;

    private Integer count;

    private Integer floorSeatSeq;

    private Integer empId;

    private String empName;

    private Integer deptId;

    private String deptName;
}
