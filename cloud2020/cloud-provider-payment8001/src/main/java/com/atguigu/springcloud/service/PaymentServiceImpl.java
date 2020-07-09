package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create( Payment payment ) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById( long id ) {


        return paymentDao.getPaymentById(id);
    }
}
