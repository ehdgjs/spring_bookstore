package com.project.bookstore.web.orders;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.bookstore.domain.address.Address;
import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.card.Card;
import com.project.bookstore.domain.order.Orders;
import com.project.bookstore.domain.orderlist.Orderlist;
import com.project.bookstore.domain.orderlist.OrderlistMultiid;
import com.project.bookstore.domain.user.Users;
import com.project.bookstore.service.BookService;
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
        @RequestParam(value = "bookUid") Long bookUid,
        @RequestParam(value = "count") Long count,
        @RequestParam(value = "cardid") String cardid,
        @RequestParam(value = "addrUid") Long addrUid) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Book book = new Book();
        book = bookService.findBookById(bookUid);
        Long totalPrice = book.getBookPrice()*count;
        
        Card card = new Card();
        card = usersService.findCardByCardId(cardid);

        Address addr = new Address();
        addr = usersService.findAddrByUid(addrUid);

        Users user = usersService.findUsers(usersInfo);
        
        //주문 생성
        OrdersCreateDto ordersCreateDto = new OrdersCreateDto();
        ordersCreateDto.setUsers(user);
        ordersCreateDto.setDate(nowDate);
        ordersCreateDto.setCardId(cardid);
        ordersCreateDto.setCardType(card.getType());
        ordersCreateDto.setCardDate(card.getDatetime());
        ordersCreateDto.setBasicaddr(addr.getBasicAddr());
        ordersCreateDto.setDetailaddr(addr.getDetailAddr());
        ordersCreateDto.setShippingNum(addr.getShippingNum());
        ordersCreateDto.setAmount(totalPrice);
        ordersService.createOrders(ordersCreateDto);
        
        Orders lastAddOrders = new Orders();
        lastAddOrders = ordersService.lastAddOrders();

        //주문리스트 생성
        OrderlistMultiid orderlistMultiid = new OrderlistMultiid();
        orderlistMultiid.setBookUid(bookUid);
        orderlistMultiid.setOrdersUid(lastAddOrders.getUid());

        OrderslistAddDto orderslistAddDto = new OrderslistAddDto();
        orderslistAddDto.setBook(book);
        orderslistAddDto.setOrderlistMultiid(orderlistMultiid);
        orderslistAddDto.setOrders(lastAddOrders);
        orderslistAddDto.setCount(count);

        ordersService.addOrderslist(orderslistAddDto);
        
        //책 개수 수정
        Long updateBookCount = book.getBookCount() - count;
        BookUpdateCountDto bookUpdateCountDto = new BookUpdateCountDto();
        bookUpdateCountDto.setBookCount(updateBookCount);
        bookService.updateCountBook(book.getUid(), bookUpdateCountDto);

    }
}
