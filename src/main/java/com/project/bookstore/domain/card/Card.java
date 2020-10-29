package com.project.bookstore.domain.card;

import com.project.bookstore.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Card {

    //카드 번호
    @Id
    private String id;

    //사용자 ID
    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    //카드 유효기간
    private String datetime;

    //카드 은행명
    private String type;

    @Builder
    public Card(String id, Users users, String datetime, String type){
        this.id = id;
        this.users = users;
        this.datetime = datetime;
        this.type = type;
    }
}
