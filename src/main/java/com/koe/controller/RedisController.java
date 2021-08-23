//package com.koe.controller;
//
//import com.koe.model.PodBase;
//import com.koe.service.PodService;
//import com.koe.service.RedisService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Api(tags = "RedisController", description = "Redis测试")
//@RestController
//@RequestMapping("/redis")
//public class RedisController {
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private PodService service;
//
//    @ApiOperation("测试简单缓存")
//    @RequestMapping(value = "/simpleTest", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<PmsBrand> simpleTest() {
//        List<PodBase> brandList = service.getPods();
//        PmsBrand brand = brandList.get(0);
//        String key = "redis:simple:" + brand.getId();
//        redisService.set(key, brand);
//        PmsBrand cacheBrand = (PmsBrand) redisService.get(key);
//        return CommonResult.success(cacheBrand);
//    }
//
//
//
//    @ApiOperation("测试List结构的缓存")
//    @RequestMapping(value = "/listTest", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<Object>> listTest() {
//        List<PmsBrand> brandList = brandService.list(1, 5);
//        String key = "redis:list:all";
//        redisService.lPushAll(key, (Object[]) ArrayUtil.toArray(brandList, PmsBrand.class));
//        redisService.lRemove(key, 1, brandList.get(0));
//        List<Object> cachedBrandList = redisService.lRange(key, 0, 3);
//        return CommonResult.success(cachedBrandList);
//    }
//}
