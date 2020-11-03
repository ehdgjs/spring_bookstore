package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.card.Card;
import com.project.bookstore.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardInfoDto {
    private String id;
    private Users users;
    private String datetime;
    private String type;

    public Card toEntity(){
        return Card.builder().id(id).users(users).datetime(datetime).type(type).build();
    }

}
