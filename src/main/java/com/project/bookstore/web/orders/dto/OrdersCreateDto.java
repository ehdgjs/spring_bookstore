package com.project.bookstore.web.orders.dto;

import com.project.bookstore.domain.order.Orders;
import com.project.bookstore.domain.user.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdersCreateDto {
    private Users users;

    private String date;

    private Long amount;

    private String cardId;

    private String cardType;

    private String cardDate;

    private Long shippingNum;

    private String basicaddr;

    private String detailaddr;

    public Orders toEntity(){
        return Orders.builder()
            .users(users)
            .date(date)
            .amount(amount)
            .cardId(cardId)
            .cardType(cardType)
            .cardDate(cardDate)
            .shippingNum(shippingNum)
            .basicaddr(basicaddr)
            .detailaddr(detailaddr)
            .build();
    }

    
}
