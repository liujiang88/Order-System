package com.example.demo.produce.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.produce.entity.CommodityFullInfo;
import com.example.demo.produce.entity.CommodityHeadImg;
import com.example.demo.produce.entity.CommodityInfo;
import com.example.demo.produce.entity.CommodityInfoImg;
import com.example.demo.produce.mapper.CommodityInfoMapper;
import com.example.demo.produce.service.ICommodityInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘江
 * @since 2020-10-26
 */
@Service
public class CommodityInfoServiceImpl extends ServiceImpl<CommodityInfoMapper, CommodityInfo> implements ICommodityInfoService {
    @Autowired
    CommodityHeadImgServiceImpl commodityHeadImgService;
    @Autowired
    CommodityInfoImgServiceImpl commodityInfoImgService;
    public CommodityFullInfo getInfoById(String id){
        QueryWrapper<CommodityInfo> commodityInfoQueryWrapper = new QueryWrapper<>();
        commodityInfoQueryWrapper.eq("commodity_id",id);
        CommodityInfo one = getOne(commodityInfoQueryWrapper);
        CommodityFullInfo commodityFullInfo = new CommodityFullInfo();

        try {
            one.getCommodityId();
            commodityFullInfo.setCommodityInfo(one);
            QueryWrapper<CommodityHeadImg> commodityHeadImgQueryWrapper = new QueryWrapper<>();
            commodityHeadImgQueryWrapper.eq("commodity_id",id);
            commodityFullInfo.setCommodityHeadImgList(commodityHeadImgService.list(commodityHeadImgQueryWrapper));
            QueryWrapper<CommodityInfoImg> commodityInfoImgQueryWrapper = new QueryWrapper<>();
            commodityInfoImgQueryWrapper.eq("commodity_id",id);
            commodityFullInfo.setCommodityInfoImgList(commodityInfoImgService.list(commodityInfoImgQueryWrapper));
            commodityFullInfo.setCode(200);
        }catch (Exception e){
            commodityFullInfo.setCode(100);
        }
        return commodityFullInfo; }

    public List<CommodityInfo> getAll(){
        QueryWrapper<CommodityInfo> commodityInfoQueryWrapper = new QueryWrapper<>();
        return  list(commodityInfoQueryWrapper);
    }
    public boolean add(String info){
        JSONObject jsonObject = JSON.parseObject(info);
//        MultipartFile

        return false;
    }
}
