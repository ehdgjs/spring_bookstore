package com.project.bookstore.domain.user;

import com.project.bookstore.domain.address.Address;
import com.project.bookstore.domain.card.Card;
import com.project.bookstore.domain.cart.Cart;
import com.project.bookstore.domain.order.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Users {

    //유저 아이디
    @Id
    private String id;

    //유저 패스워드
    private String pw;

    //유저 이름
    private String name;

    @OneToMany(mappedBy = "users")
    private List<Card> card;

    @OneToMany(mappedBy = "users")
    private List<Address> address;

    @OneToMany(mappedBy = "users")
    private List<Cart> cart;

    @OneToMany(mappedBy = "users")
    private List<Orders> orders;

    @Builder
    public Users(String id, String pw, String name, List<Card> card, List<Address> address, List<Cart> cart, List<Orders> orders){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.card = card;
        this.address = address;
        this.cart = cart;
        this.orders = orders;
    }

}
