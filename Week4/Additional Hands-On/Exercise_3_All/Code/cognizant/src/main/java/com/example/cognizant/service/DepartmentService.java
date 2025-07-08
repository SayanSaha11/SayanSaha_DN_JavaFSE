package com.example.cognizant.service;

import com.example.cognizant.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<String> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }
}
