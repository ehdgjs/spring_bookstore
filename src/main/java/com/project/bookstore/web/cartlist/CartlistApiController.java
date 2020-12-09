package com.project.bookstore.web.cartlist;

import java.util.List;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.BookService;
import com.project.bookstore.service.CartlistService;
import com.project.bookstore.web.cartlist.dto.CartlistAddDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "카트", description = "카트 관리", tags = { "카트" })
@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartlistApiController {
    private final CartlistService cartlistService;
    private final BookService bookService;

    @ApiOperation(value = "장바구니 추가")
    @PostMapping("/addCartlist/{bookUid}")
    public ResponseEntity<?> addCartlist(@PathVariable(value = "bookUid") Long bookUid, @RequestBody CartlistAddDto cartlistAddDto) {
        ApiResponse result = null;
        try {
            if (cartlistService.existCart() == true){
                System.out.println("Exist Cart");
                result = new ApiResponse(true, "성공", cartlistService.addCartlist(bookUid, cartlistAddDto));
                cartlistService.updateModifyTimeInCart();
                return ResponseEntity.ok().body(result);
            }else {
                System.out.println("Not Extist Cart");
                cartlistService.createCart();
                result = new ApiResponse(true, "성공", cartlistService.addCartlist(bookUid, cartlistAddDto));
                return ResponseEntity.ok().body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/deleteCartlist")
    public void deleteCartlist(@RequestParam(value = "checkArr[]") List<Long> valueArr){
        for (Long string : valueArr) {
            cartlistService.deleteCartlist(string);
        }
    }



}
