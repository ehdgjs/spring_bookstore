package com.project.bookstore.domain.cart;

import com.project.bookstore.domain.cartlist.Cartlist;
import com.project.bookstore.domain.cartlist.MultiId;
import com.project.bookstore.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart {

    //장바구니 UID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    //사용자 아이디
    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    //장바구니 생성일자
    private String createtime;

    //장바구니 수정일자
    private String modifytime;

    @OneToMany(mappedBy = "cart")
    private List<Cartlist> cartlists;

    @Builder
    public Cart(Long uid, Users users, String createtime, String modifytime, List<Cartlist> cartlists){
        this.uid = uid;
        this.users = users;
        this.createtime = createtime;
        this.modifytime = modifytime;
        this.cartlists = cartlists;
    }
}
