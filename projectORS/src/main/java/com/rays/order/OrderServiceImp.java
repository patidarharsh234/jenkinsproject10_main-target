package com.rays.order;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;


@Service
@Transactional
public class OrderServiceImp extends BaseServiceImpl<OrderDTO, OrderDAOInt> implements OrderServiceInt {

}
