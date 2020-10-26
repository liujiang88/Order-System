package com.example.demo.produce.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.produce.entity.CommodityFullInfo;
import com.example.demo.produce.entity.CommodityInfo;
import com.example.demo.produce.serviceImp.CommodityInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘江
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/produce/commodity-info")
public class CommodityInfoController {
     @Autowired
    CommodityInfoServiceImpl commodityInfoService;
    @GetMapping("/getById")
     public CommodityInfo getById(@RequestParam Integer id){
        return commodityInfoService.getById(id);
    }
    @GetMapping("/getFullById")
    public String getFullInfo(@RequestParam String id){
      return JSON.toJSONString(commodityInfoService.getInfoById(id));
    }
    @GetMapping("/getAll")
    public String getAll(){
        return JSON.toJSONString(commodityInfoService.getAll());
    }
    @PostMapping("/addInfo")
    public boolean addInfo(@RequestBody String info){
        return commodityInfoService.add(info);
    }
}

