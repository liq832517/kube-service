package com.koe.controller;

import com.koe.model.PodBase;
import com.koe.service.PodService;
import com.koe.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@Api(tags = "Pod管理")
@RequestMapping("/pod")
public class PodController {
    @Resource
    private RedisService redisService;
    @Resource
    private PodService podService;

    @PostMapping("/list")
    @ApiModelProperty("Pod列表")

    public ResponseEntity<List<Object>> getPods(@ApiParam("pod列表查询参数") @RequestBody Map<String,Object> req){
        List<PodBase> list=podService.getPods(req);
        String key = "redis:list:all";
        redisService.lPushAll(key, list);
        redisService.lRemove(key, 1, list.get(0));
        List<Object> cachedList = redisService.lRange(key, 0, 3);


        return ResponseEntity.ok(cachedList);
    }

    @PostMapping("/count")
    @ApiModelProperty("Pod数量")
    public ResponseEntity<Integer> getPodCount(@ApiParam("pod数量查询参数") @RequestBody Map<String,Object> req){
        return ResponseEntity.ok(podService.getPodCounts(req));
    }

    @PostMapping("/ns")
    @ApiModelProperty("Pod数量")
    public ResponseEntity<List<String>> ns(@ApiParam("pod数量查询参数") @RequestBody Map<String,Object> req){
        return ResponseEntity.ok(podService.ns(req));
    }

    @PostMapping("/test")
    @ApiModelProperty("test")
    public ResponseEntity<Void> test(){
        podService.init();
        return ResponseEntity.ok().build();
    }
}
