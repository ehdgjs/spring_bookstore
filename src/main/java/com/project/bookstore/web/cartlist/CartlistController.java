package com.project.bookstore.web.cartlist;

import com.project.bookstore.service.CartlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CartlistController {
    private final CartlistService cartlistService;


}
