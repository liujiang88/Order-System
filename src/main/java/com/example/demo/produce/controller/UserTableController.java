package com.example.demo.produce.controller;


import com.example.demo.produce.serviceImp.UserTableServiceImpl;
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
@RequestMapping("/produce/user-table")
public class UserTableController {
    @Autowired
    UserTableServiceImpl userTableService;

    @GetMapping("/login")
    public  boolean Login(@RequestParam String name, @RequestParam String password){
     return   userTableService.Log(name, password);
    }
}

