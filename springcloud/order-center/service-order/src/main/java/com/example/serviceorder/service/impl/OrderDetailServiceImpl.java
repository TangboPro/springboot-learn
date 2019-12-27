package com.example.serviceorder.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.baseorder.entry.OrderDetail;
import com.example.serviceorder.dao.OrderDetailMapper;
import com.example.serviceorder.service.OrderDetailService;
/**
 * @Classname OrderDetailServiceImpl
 * @Description TODO
 * @Date 2019/12/26 21:51
 * @author tang
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService{

}
