package com.koe.service;

import com.koe.config.RedisConfig;
import com.koe.dao.PodMapper;
import com.koe.model.PodBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PodService {

    @Resource
    private PodMapper podMapper;

    private final static Logger logger= LoggerFactory.getLogger(PodService.class);

    private final static String[] cluster={"leishengchan","ceshi","211","21Test"};
    private final static String[] ns={"2s","3s","4s","zls"};
    private final static String[] status={"Running","Padding","CrashLoopBackoff","Terminating"};

    public void log(){
        logger.debug("test");
        logger.info("test");
        logger.error("test");
        logger.warn("test");
    }

    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'pms:brand:'+#id", unless = "#result==null")
    public List<PodBase> getPods(Map<String,Object> req){
        return podMapper.selectBase(req);
    }

    public Integer getPodCounts(Map<String,Object> req){

        System.out.println(req);
        return podMapper.selectCnt(req);
    }

    public void init(){

        List<PodBase> list=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            PodBase podBase=new PodBase();
            podBase.setClusterName(cluster[(int) (Math.random() * cluster.length)]);
            podBase.setNamespace(ns[(int) (Math.random() * ns.length)]);
            podBase.setCreationTime(new Date().getTime());
            podBase.setName(String.valueOf(Math.random()));
            podBase.setStatus(status[(int) (Math.random() * status.length)]);
            list.add(podBase);
        }
        podMapper.insertList(list);

    }

    public List<String> ns(Map<String,Object> req){
        return podMapper.selectNs(req);
    }
}
