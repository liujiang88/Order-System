package com.example.demo.produce.controller;


import com.example.demo.produce.serviceImp.UserOrderServiceImpl;
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
@RequestMapping("/produce/user-order")
public class UserOrderController {
     @Autowired
     UserOrderServiceImpl userOrderService;
     @PostMapping("/addOrder")
     public boolean addOrder(@RequestBody String info){
     return   userOrderService.addOrder(info);
    }
    @PostMapping("/updateState")
    public boolean updateState(@RequestBody String info){
         return  userOrderService.updateState(info);
    }
}

