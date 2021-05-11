package com.github.abhishek.user.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    //We just need the Pojo's over here from the department service
    private Long departmentId;
    private String departmentName;
    private  String departmentAddress;
    private  String departmentCode;
}
