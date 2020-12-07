package com.project.bookstore.web.orders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.bookstore.domain.address.Address;
import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.card.Card;
import com.project.bookstore.domain.order.Orders;
import com.project.bookstore.domain.orderlist.Orderlist;
import com.project.bookstore.domain.orderlist.OrderlistMultiid;
import com.project.bookstore.domain.user.Users;
import com.project.bookstore.service.BookService;
import com.project.bookstore.service.CartlistService;
import com.project.bookstore.service.OrdersService;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.books.dto.BookUpdateCountDto;
import com.project.bookstore.web.orders.dto.OrdersCreateDto;
import com.project.bookstore.web.orderslist.dto.OrderslistAddDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(value = "주문", description = "주문 관리", tags = { "주문" })
@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrdersApiController {
    private final CartlistService cartlistService;
    private final OrdersService ordersService;
    private final UsersService usersService;
    private final UsersInfo usersInfo;
    private final BookService bookService;

    //현재시간
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);
    //

    //바로주문
    @PostMapping("/addOrder")
    @ResponseBody
    public void addOrder(
        @RequestParam(value = "bookUid[]") List<Long> bookUid,
        @RequestParam(value = "count[]") List<Long> count,
        @RequestParam(value = "cardid") String cardid,
        @RequestParam(value = "addrUid") Long addrUid) {
        
        //주문 생성
        ordersService.createOrders(bookUid, count, cardid, addrUid);

        //주문리스트 생성
        ordersService.addOrderslist(bookUid, count);

        //책 개수 수정
        bookService.updateCountBook(bookUid, count);

    }

    @PostMapping("/cartOrder")
    @ResponseBody
    public void cartlistOrder(
        @RequestParam(value = "bookUid[]") List<Long> bookUid,
        @RequestParam(value = "count[]") List<Long> count,
        @RequestParam(value = "cardid") String cardid,
        @RequestParam(value = "addrUid") Long addrUid
    ){
        
        //주문 생성
        ordersService.createOrders(bookUid, count, cardid, addrUid);

        //주문리스트 생성
        ordersService.addOrderslist(bookUid, count);

        //책 개수 수정
        bookService.updateCountBook(bookUid, count);

        //장바구니 삭제
        cartlistService.deleteCart();

    }
}
