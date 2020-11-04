package com.project.bookstore.service;

import com.project.bookstore.domain.address.Address;
import com.project.bookstore.domain.address.AddressRepository;
import com.project.bookstore.domain.card.Card;
import com.project.bookstore.domain.card.CardRepository;
import com.project.bookstore.domain.user.Users;
import com.project.bookstore.domain.user.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.user.dto.AddrInfoDto;
import com.project.bookstore.web.user.dto.CardInfoDto;
import com.project.bookstore.web.user.dto.UsersSignInDto;
import com.project.bookstore.web.user.dto.UsersSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final CardRepository cardRepository;
    private final AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public Users findUsers(UsersInfo usersInfo){
        return usersRepository.findById(usersInfo.getUserId()).get();
    }

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

    @Transactional(readOnly = true)
    public List<Card> findAllCard(UsersInfo usersInfo){
        return cardRepository.findAllByUsers_Id(usersInfo.getUserId());
    }

    @Transactional
    public String addCard(CardInfoDto cardInfoDto){
        return cardRepository.save(cardInfoDto.toEntity()).getId();
    }

    @Transactional
    public void deleteCard(String cardId) {
        cardRepository.delete(cardRepository.findById(cardId).get());
    }

    @Transactional(readOnly = true)
    public List<Address> findAllAddr(UsersInfo usersInfo){
        return addressRepository.findAllByUsers_Id(usersInfo.getUserId());
    }

    @Transactional
    public Long addAddr(AddrInfoDto addrInfoDto){
        return addressRepository.save(addrInfoDto.toEntity()).getUid();
    }

    @Transactional
    public void deleteAddr(Long addrUid){
        addressRepository.delete(addressRepository.findById(addrUid).get());
    }

}
