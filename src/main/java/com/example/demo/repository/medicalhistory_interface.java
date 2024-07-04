package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.obj.Medicalhistorydata;


public interface medicalhistory_interface extends JpaRepository<Medicalhistorydata, Integer>  {

}
