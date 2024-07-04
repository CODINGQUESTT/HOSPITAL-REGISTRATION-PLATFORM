package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.obj.Addressdata;


public interface address_interface extends JpaRepository<Addressdata, Integer> {

}
