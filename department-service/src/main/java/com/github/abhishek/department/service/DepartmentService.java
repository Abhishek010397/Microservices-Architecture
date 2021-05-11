package com.github.abhishek.department.service;


import com.github.abhishek.department.entity.Department;
import com.github.abhishek.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    //Create the Object of DepartmentRepository
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        //call the Department Repository
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
