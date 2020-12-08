package com.project.bookstore.web.user;


import com.project.bookstore.config.PasswordEncoding;
import com.project.bookstore.domain.user.Users;
import com.project.bookstore.domain.user.UsersRepository;
import com.project.bookstore.web.user.dto.UsersSignUpDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiControllerTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    PasswordEncoding passwordEncoding = new PasswordEncoding();

    @After
    public void tearDown() throws Exception{
        usersRepository.deleteById("test");
    }

    @Test
    public void 회원가입() throws Exception{
        //given
        String id = "test";
        String pw = "test";
        String name = "test";

        UsersSignUpDto upDto = UsersSignUpDto.builder().id(id).pw(pw).name(name).build();

        String url = "http://localhost:"+ port + "/users/signup";

        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, upDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Users users = usersRepository.findById(id).get();
        assertThat(users.getId()).isEqualTo(id);
        assertThat(passwordEncoding.matches(pw, users.getPw())).isTrue();
        assertThat(users.getName()).isEqualTo(name);
    }




}
