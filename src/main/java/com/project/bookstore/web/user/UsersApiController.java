package com.project.bookstore.web.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.web.user.dto.UsersSignUpDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping("/signup_ok")
    public String signupPosts(@RequestBody UsersSignUpDto usersSignUpDto){
        return usersService.signup(usersSignUpDto);
    }
}
