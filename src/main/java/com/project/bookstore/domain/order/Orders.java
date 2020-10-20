package com.project.bookstore.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Orders {

    //주문번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자아이디
    @Column(name = "USERS_ID")
    private String usersId;

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
    private String basicaddr;

    //상세주소
    private String detailaddr;


    @Builder
    public Orders(Long uid, String usersId, String date, Long amount, String cardId, String cardType, String cardDate, Long shippingNum, String basicaddr, String detailaddr){
        this.uid= uid;
        this.usersId = usersId;
        this.date = date;
        this.amount = amount;
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardDate= cardDate;
        this.shippingNum = shippingNum;
        this.basicaddr = basicaddr;
        this.detailaddr = detailaddr;
    }

}
