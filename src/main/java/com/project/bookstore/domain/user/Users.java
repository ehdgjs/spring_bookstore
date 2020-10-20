package com.project.bookstore.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Builder
    public Users(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

}
