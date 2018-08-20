package com.autumn.service;

import com.autumn.mapper.ConcategoryMapper;
import com.autumn.pojo.Concategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class CommonService {

    @Autowired
    public ConcategoryMapper concategoryMapper;

    public List<Concategory> getAllCate(){
        List<Concategory> result = concategoryMapper.getAllCate();
        return result;
    }
}
