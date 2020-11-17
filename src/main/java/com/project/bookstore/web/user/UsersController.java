package com.project.bookstore.web.user;

import com.project.bookstore.service.BookService;
import com.project.bookstore.service.CartlistService;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;
    private final UsersInfo usersInfo;
    private final BookService bookService;
    private final CartlistService cartlistService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("bookInfo", bookService.findAllBook());
        if(usersInfo.getUserId() != null){
            if(usersInfo.getUserId().equals("master")){
                model.addAttribute("master", usersInfo.getUserId());
            }
        }
        return "main";
    }

    @GetMapping("/users/login")
    public String login() {return "users/login";}

    @GetMapping("/users/signup")
    public String signup() {return "users/signup";}

    @GetMapping("/users/mypage")
    public String mypage(Model model)
    {
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cardInfo", usersService.findAllCard(usersInfo));
        model.addAttribute("addrInfo", usersService.findAllAddr(usersInfo));
        return "users/mypage";
    }

    @GetMapping("/users/cartlist")
    public String cartlist(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cartlstInfo", cartlistService.findByCartuid());
        return "users/cartlist";
    }

}
