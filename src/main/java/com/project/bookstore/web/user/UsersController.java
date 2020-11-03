package com.project.bookstore.web.user;

import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;
    private final UsersInfo usersInfo;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        return "main";
    }

    @GetMapping("/users/login")
    public String login() {return "users/login";}

    @GetMapping("/users/signup")
    public String signup() {return "users/signup";}


}
