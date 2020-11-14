package com.project.bookstore.service;

import com.project.bookstore.domain.book.BookRepository;
import com.project.bookstore.domain.cart.Cart;
import com.project.bookstore.domain.cart.CartRepository;
import com.project.bookstore.domain.cartlist.CartlistRepository;
import com.project.bookstore.domain.cartlist.MultiId;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.cartlist.dto.CartCreateDto;
import com.project.bookstore.web.cartlist.dto.CartlistAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class CartlistService {
    private final UsersInfo usersInfo;
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;
    private final CartlistRepository cartlistRepository;
    private final UsersService usersService;
    private final BookService bookService;

    //현재시간
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);
    //

    @Transactional(readOnly = true)
    public Cart cartfindByUser(){
        return cartRepository.findByUsers_Id(usersInfo.getUserId());
    }

    @Transactional(readOnly = true)
    public boolean existCart(){
        if(cartRepository.findByUsers_Id(usersInfo.getUserId()) != null){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public String createCart(){
        CartCreateDto cartCreateDto = new CartCreateDto();
        cartCreateDto.setCreatetime(nowDate);
        cartCreateDto.setModifytime(nowDate);
        cartCreateDto.setUsers(usersService.findUsers(usersInfo));

        return cartRepository.save(cartCreateDto.toEntity()).toString();
    }

    @Transactional
    public String addCartlist(Long bookUid, CartlistAddDto cartlistAddDto){
        Long cartUid = cartRepository.findByUsers_Id(usersInfo.getUserId()).getUid();
        MultiId multiId = new MultiId();
        multiId.setCartUid(cartUid);
        multiId.setBookUid(bookUid);
        cartlistAddDto.setMultiId(multiId);
        cartlistAddDto.setBook(bookService.findBookById(bookUid));
        cartlistAddDto.setCart(cartfindByUser());

        return cartlistRepository.save(cartlistAddDto.toEntity()).toString();
    }

    @Transactional
    public void updateModifyTimeInCart(){
        Cart cart = cartfindByUser();
        cart.updateModifytime(nowDate);
    }



}
