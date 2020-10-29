package com.project.bookstore.web.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.web.user.dto.UsersSignInDto;
import com.project.bookstore.web.user.dto.UsersSignUpDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Parser;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;

//    @ApiOperation(value = "로그인")
//    @PostMapping("/login")
//    public ResponseEntity<?> loginGet(@RequestBody UsersSignInDto usersSignInDto){
//        ApiResponse result = null;
//        try {
//
//        }catch (Exception e){
//
//        }
//    }

    @ApiOperation(value = "회원가입")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
//            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/signup_ok")
    public String signupPosts(@RequestBody UsersSignUpDto usersSignUpDto){
        return usersService.signup(usersSignUpDto);
    }
}
