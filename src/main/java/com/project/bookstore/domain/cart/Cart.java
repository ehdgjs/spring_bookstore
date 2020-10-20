package com.project.bookstore.domain.cart;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Cart {

    //장바구니 UID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자 아이디
    @Column(name = "USERS_ID")
    private String usersId;

    //장바구니 생성일자
    private String createtime;

    //장바구니 수정일자
    private String modifytime;

    @Builder
    public Cart(Long uid, String usersId, String createtime, String modifytime){
        this.uid = uid;
        this.usersId = usersId;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }
}
