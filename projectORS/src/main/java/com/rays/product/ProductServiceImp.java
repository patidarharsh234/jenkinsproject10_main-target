package com.rays.product;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;


@Service
@Transactional
public class ProductServiceImp extends BaseServiceImpl<ProductDTO, ProductDAOInt> implements ProductServiceInt {

}
