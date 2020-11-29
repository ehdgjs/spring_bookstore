package com.project.bookstore.web.orders;

import com.project.bookstore.service.BookService;
import com.project.bookstore.service.OrdersService;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrdersController {
    private final UsersInfo usersInfo;
    private final OrdersService ordersService;
    private final UsersService usersService;
    private final BookService bookservice;

    @GetMapping("/orders/addOrder")
    public String addOrder(@RequestParam(value = "bookUid") Long bookUid, @RequestParam(value="count") Long count ,Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cardInfo", usersService.findAllCard(usersInfo));
        model.addAttribute("addrInfo", usersService.findAllAddr(usersInfo));
        model.addAttribute("bookInfo", bookservice.findBookById(bookUid));
        model.addAttribute("count", count);

        return "orders/addOrder";
    }


}
