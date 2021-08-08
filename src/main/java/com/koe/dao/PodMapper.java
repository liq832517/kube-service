package com.koe.dao;

import com.koe.model.PodBase;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;
import java.util.Map;

public interface PodMapper extends Mapper<PodBase>, InsertListMapper<PodBase>{
    List<PodBase> selectBase(@Param("pod") Map<String,Object> req);

    List<String> selectNs(@Param("pod") Map<String,Object> req);
    Integer selectCnt(@Param("pod") Map<String,Object> req);


//    List<PodBase> selectBase(@Param("name") List<String> name,@Param("clusterName") List<String> clusterName,@Param("namespace") List<String> namespace,@Param("status") List<String> status);
}
