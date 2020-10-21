package com.project.bookstore.service;

import com.project.bookstore.domain.user.UsersRepository;
import com.project.bookstore.web.user.dto.UsersSignUpDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

}
