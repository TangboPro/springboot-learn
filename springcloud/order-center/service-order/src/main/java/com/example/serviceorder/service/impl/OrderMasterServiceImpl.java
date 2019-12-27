package com.example.serviceorder.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serviceorder.dao.OrderMasterMapper;
import com.example.baseorder.entry.OrderMaster;
import com.example.serviceorder.service.OrderMasterService;
/**
 * @Classname OrderMasterServiceImpl
 * @Description TODO
 * @Date 2019/12/26 21:51
 * @author tang
 */
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService{

}
