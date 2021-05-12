package com.tionkior.service;

import com.tionkior.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();

}
