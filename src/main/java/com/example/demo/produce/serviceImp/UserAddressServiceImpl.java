package com.example.demo.produce.serviceImp;

import com.example.demo.produce.entity.UserAddress;
import com.example.demo.produce.mapper.UserAddressMapper;
import com.example.demo.produce.service.IUserAddressService;
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
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
