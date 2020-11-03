package com.project.bookstore.service;

import com.project.bookstore.domain.user.UsersRepository;
import com.project.bookstore.web.user.dto.UsersSignInDto;
import com.project.bookstore.web.user.dto.UsersSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public String signup(UsersSignUpDto usersSignUpDto){
        return usersRepository.save(usersSignUpDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public boolean signin(UsersSignInDto usersSignInDto){
        try {
            String dbResultPw = usersRepository.getOne(usersSignInDto.getId()).getPw();
            String bodyResultPw = usersSignInDto.getPw();
            return dbResultPw.equals(bodyResultPw);
        } catch (Exception e){
            return false;
        }
    }

}
