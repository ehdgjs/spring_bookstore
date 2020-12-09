package com.project.bookstore.web.cartlist;

import com.project.bookstore.service.CartlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CartlistController {
    private final CartlistService cartlistService;


}
