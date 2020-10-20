package com.project.bookstore.domain.card;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Card {

    //카드 번호
    @Id
    private String id;

    //사용자 ID
    @Column(name = "USERS_ID")
    private String usersId;

    //카드 유효기간
    private String datetime;

    //카드 은행명
    private String type;
}
