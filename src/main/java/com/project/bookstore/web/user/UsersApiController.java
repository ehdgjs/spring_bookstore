package com.project.bookstore.web.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.user.dto.AddrInfoDto;
import com.project.bookstore.web.user.dto.CardInfoDto;
import com.project.bookstore.web.user.dto.UsersSignInDto;
import com.project.bookstore.web.user.dto.UsersSignUpDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.parser.Parser;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;
    private final UsersInfo usersInfo;

    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsersSignInDto usersSignInDto){
        ApiResponse result = null;
        try {
            if (usersService.signin(usersSignInDto) == true){
                result = new ApiResponse(true, "성공", usersService.signin(usersSignInDto));
                usersInfo.setUserId(usersSignInDto.getId());
                return ResponseEntity.ok().body(result);
            }else {
                result = new ApiResponse(true, "실패", usersService.signin(usersSignInDto));
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e){
          e.printStackTrace();
          result = new ApiResponse(false, e.getMessage(), null);
          return ResponseEntity.badRequest().body(result);
        }
    }


    @ApiOperation(value = "회원가입")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
//            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/signup")
    public ResponseEntity<?> signupPosts(@RequestBody UsersSignUpDto usersSignUpDto){
        ApiResponse result = null;
        try {
            if(usersService.findUsersById(usersSignUpDto.getId()) == false){
                result = new ApiResponse(true, "성공", usersService.signup(usersSignUpDto));
                return ResponseEntity.ok().body(result);
            }else{
                result = new ApiResponse(false, "실패", usersService.findUsersById(usersSignUpDto.getId()));
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "카드추가")
    @PostMapping("/addCard")
    public ResponseEntity<?> addCard(@RequestBody CardInfoDto cardInfoDto){
        ApiResponse result = null;
        try {
            cardInfoDto.setUsers(usersService.findUsers(usersInfo));
            result = new ApiResponse(true, "성공", usersService.addCard(cardInfoDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }

    }

    @ApiOperation(value = "카드삭제")
    @PostMapping("/deleteCard/{cardId}")
    public RedirectView deleteCard(@PathVariable("cardId") String cardid){
        usersService.deleteCard(cardid);
        return new RedirectView("/users/mypage");
    }

    @ApiOperation(value = "주소추가")
    @PostMapping("/addAddr")
    public ResponseEntity<?> addAddr(@RequestBody AddrInfoDto addrInfoDto){
        ApiResponse result = null;
        try {
            addrInfoDto.setUsers(usersService.findUsers(usersInfo));
            result = new ApiResponse(true, "성공", usersService.addAddr(addrInfoDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "주소삭제")
    @PostMapping("/deleteAddr/{addrUid}")
    public RedirectView deleteAddr(@PathVariable("addrUid") Long uid){
        usersService.deleteAddr(uid);
        return new RedirectView("/users/mypage");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ApiResponse result = null;
        usersInfo.setUserId(null);
        result = new ApiResponse(true, "성공", usersInfo.getUserId());
        return ResponseEntity.ok().body(result);
    }
}
