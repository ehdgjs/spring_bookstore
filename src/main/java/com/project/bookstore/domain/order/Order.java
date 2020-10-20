package com.project.bookstore.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Order {

    //주문번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자아이디
    @Column(name = "USERS_ID")
    private String userId;

    //주문날짜
    private String date;

    //주문합계
    private Long amount;

    //카드 번호
    private String cardId;

    //카드 종류
    private String cardType;

    //카드 유효기간
    private String cardDate;

    //우편번호
    private Long shippingNum;

    //기본주소
    private String basicAddr;

    //상세주소
    private String detailAddr;


    @Builder
    public Order(Long uid, String userId, String date, Long amount, String cardId, String cardType, String cardDate, Long shippingNum, String basicAddr, String detailAddr){
        this.uid= uid;
        this.userId = userId;
        this.date = date;
        this.amount = amount;
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardDate= cardDate;
        this.shippingNum = shippingNum;
        this.basicAddr = basicAddr;
        this.detailAddr = detailAddr;
    }

}
