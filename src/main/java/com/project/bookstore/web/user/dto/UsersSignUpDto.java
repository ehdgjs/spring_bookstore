package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignUpDto {
    private String id;
    private String pw;
    private String name;

    public Users toEntity(){
        return Users.builder()
                .id(id).pw(pw).name(name).build();
    }
}
