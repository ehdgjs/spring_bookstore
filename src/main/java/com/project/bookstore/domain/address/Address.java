package com.project.bookstore.domain.address;

import jdk.jfr.Name;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Address {

    //주소 UID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자 아이디
    @Column(name = "USERS_ID")
    private String usersId;

    //우편번호
    private Long shippingNum;

    //기본주소
    private String basicAddr;

    //상세주소
    private String detailAddr;

    @Builder
    public Address(Long uid, String usersId, Long shippingNum, String basicAddr, String detailAddr){
        this.uid = uid;
        this.usersId = usersId;
        this.shippingNum = shippingNum;
        this.basicAddr = basicAddr;
        this.detailAddr = detailAddr;
    }
}
