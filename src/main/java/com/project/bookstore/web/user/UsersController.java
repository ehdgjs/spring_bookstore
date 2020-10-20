package com.project.bookstore.web.user;

import com.project.bookstore.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService = null;

    @GetMapping("/")
    public String main(){
        return "main";
    }

}
