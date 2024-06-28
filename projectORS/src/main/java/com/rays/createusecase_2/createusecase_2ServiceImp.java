package com.rays.createusecase_2;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;


@Service
@Transactional
public class createusecase_2ServiceImp extends BaseServiceImpl<createusecase_2DTO, createusecase_2DAOInt> implements createusecase_2ServiceInt {

}
