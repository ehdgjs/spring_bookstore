package com.project.bookstore.web.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.user.dto.UsersSignInDto;
import com.project.bookstore.web.user.dto.UsersSignUpDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @PostMapping("/signup_ok")
    public String signupPosts(@RequestBody UsersSignUpDto usersSignUpDto){
        return usersService.signup(usersSignUpDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ApiResponse result = null;
        usersInfo.setUserId(null);
        result = new ApiResponse(true, "성공", usersInfo.getUserId());
        return ResponseEntity.ok().body(result);
    }
}
