package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.obj.Departmentdata;


public interface department_interface extends JpaRepository<Departmentdata, Integer> {

}
