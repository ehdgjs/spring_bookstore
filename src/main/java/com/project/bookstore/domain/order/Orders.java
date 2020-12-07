package com.project.bookstore.domain.order;

import com.project.bookstore.domain.orderlist.Orderlist;
import com.project.bookstore.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Orders {

    //주문번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자아이디
    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

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

    @OneToMany(mappedBy = "orders")
    private List<Orderlist> orderlists;


    @Builder
    public Orders(Long uid, Users users, String date, Long amount, String cardId, String cardType, String cardDate, Long shippingNum, String basicaddr, String detailaddr, List<Orderlist> orderlists){
        this.uid= uid;
        this.users = users;
        this.date = date;
        this.amount = amount;
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardDate= cardDate;
        this.shippingNum = shippingNum;
        this.basicaddr = basicaddr;
        this.detailaddr = detailaddr;
        this.orderlists = orderlists;
    }

}
