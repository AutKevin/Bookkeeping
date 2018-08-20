package com.autumn.mapper;

import com.autumn.pojo.Concategory;
import com.autumn.pojo.ConcategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConcategoryMapper {
    /*获取所有类别个数*/
    int getAllCateCount();

    /*获取所有类别*/
    List<Concategory> getAllCate();

    /*分页显示*/
    List<Concategory> getAllCateByPage(@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);
    /*判断是否被使用*/
    int getCodeIsUse(String cate_code);
    int countByExample(ConcategoryExample example);

    int deleteByExample(ConcategoryExample example);

    int deleteByPrimaryKey(String cateCode);

    int insert(Concategory record);

    int insertSelective(Concategory record);

    List<Concategory> selectByExampleByPage(ConcategoryExample example);

    Concategory selectByPrimaryKey(String cateCode);

    int updateByExampleSelective(@Param("record") Concategory record, @Param("example") ConcategoryExample example);

    int updateByExample(@Param("record") Concategory record, @Param("example") ConcategoryExample example);

    int updateByPrimaryKeySelective(Concategory record);

    int updateByPrimaryKey(Concategory record);
}