package com.example.demo.produce.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.produce.entity.UserTable;
import com.example.demo.produce.mapper.UserTableMapper;
import com.example.demo.produce.service.IUserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘江
 * @since 2020-10-26
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements IUserTableService {

    public  boolean Log(String name,String password){
        QueryWrapper<UserTable> userTableQueryWrapper = new QueryWrapper<>();
        userTableQueryWrapper.eq("name",name).eq("password",password);
        UserTable one = getOne(userTableQueryWrapper);
        try {
            one.getName();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
