package com.example.demo.produce.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.produce.entity.UserOrder;
import com.example.demo.produce.mapper.UserOrderMapper;
import com.example.demo.produce.service.IUserOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘江
 * @since 2020-10-26
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements IUserOrderService {

       public boolean addOrder(String info){
           JSONObject jsonObject = JSON.parseObject(info);
           String userId = jsonObject.getString("userId");
           String commodityId = jsonObject.getString("commodityId");
           String addressId = jsonObject.getString("addressId");
           Integer commodityNumber = jsonObject.getInteger("commodityNumber");
           String leaveWord = jsonObject.getString("leaveWord");
           UserOrder userOrder = new UserOrder();
           userOrder.setUserId(userId).setCommodityId(commodityId).setAddressId(addressId).setCommodityNumber(commodityNumber).setLeaveWord(leaveWord).setState(1)
            .setCreatTime(new Date()).setUpdateTime(new Date());
           return save(userOrder);

       }
       public boolean updateState(String info){
           JSONObject jsonObject = JSON.parseObject(info);
           Integer id = jsonObject.getInteger("id");
           Integer state = jsonObject.getInteger("state");
           UpdateWrapper<UserOrder> userOrderUpdateWrapper = new UpdateWrapper<>();
           userOrderUpdateWrapper.eq("id",id);
          return update(new UserOrder().setState(state),userOrderUpdateWrapper);
       }
}
