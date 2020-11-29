package com.project.bookstore.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.bookstore.domain.order.Orders;
import com.project.bookstore.domain.order.OrdersRepository;
import com.project.bookstore.domain.orderlist.OrderlistRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.orders.dto.OrdersCreateDto;
import com.project.bookstore.web.orderslist.dto.OrderslistAddDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderlistRepository orderlistRepository;
    private final UsersInfo usersInfo;


    //주문 등록
    @Transactional
    public void createOrders(OrdersCreateDto ordersCreateDto){
        ordersRepository.save(ordersCreateDto.toEntity());
    }

    //주문 추가
    @Transactional
    public void addOrderslist(OrderslistAddDto orderslistAddDto){
        orderlistRepository.save(orderslistAddDto.toEntity());
    }

    //최근 추가된 주문
    @Transactional(readOnly = true)
    public Orders lastAddOrders(){
        return ordersRepository.findAllByOrderByUidAsc().get(0);
    }
}
