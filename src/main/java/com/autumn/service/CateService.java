package com.autumn.service;

import com.autumn.mapper.ConcategoryMapper;
import com.autumn.pojo.Concategory;
import com.autumn.pojo.ConcategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Autumn on 2018/6/6.
 */
@Service
public class CateService {

    @Autowired
    public ConcategoryMapper conCateMapper;

    /**
     * 获取所有个数
     * @return
     */
    public Integer getAllCate() {
        return conCateMapper.getAllCateCount();
    }

    /**
     * 获取所有类型分页显示
     * @return
     */
    public List<Concategory> getAllCateByPage(String pageNo,String pageSize) {
        ConcategoryExample concategoryExample = new ConcategoryExample();
        List<Concategory> result = conCateMapper.getAllCateByPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        return result;
    }

    /**
     * 添加
     * @param cate
     * @return
     */
    public int addCate(Concategory cate) {
        return conCateMapper.insertSelective(cate);
    }

    /**
     * 删除
     * @param cate
     * @return
     */
    public int delCate(Concategory cate) {
        return conCateMapper.deleteByPrimaryKey(cate.getCate_code());
    }

    /**
     * 判断编码是否被使用
     * @param cate
     * @return
     */
    public boolean getCountByCode(Concategory cate) {
        return conCateMapper.getCodeIsUse(cate.getCate_code())>0?true:false;
    }
}
