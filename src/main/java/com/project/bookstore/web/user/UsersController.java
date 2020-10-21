package com.project.bookstore.web.user;

import com.project.bookstore.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService = null;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/users/login")
    public String login() {return "users/login";}

    @GetMapping("/users/signup")
    public String signup() {return "users/signup";}

}
