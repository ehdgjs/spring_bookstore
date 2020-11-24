package com.project.bookstore.web.cartlist;

import java.util.List;
import java.util.Map;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.domain.cartlist.MultiId;
import com.project.bookstore.service.BookService;
import com.project.bookstore.service.CartlistService;
import com.project.bookstore.web.cartlist.dto.CartCreateDto;
import com.project.bookstore.web.cartlist.dto.CartlistAddDto;
import com.project.bookstore.web.cartlist.dto.CartlistDeleteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping(value = "/deleteCartlist", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCartlist(@RequestParam(value = "checkArr[]") List<String> valueArr){
        for (String a : valueArr) {
            System.out.println(a);
        }
    }



}
