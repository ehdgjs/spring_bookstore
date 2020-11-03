package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.address.Address;
import com.project.bookstore.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddrInfoDto {
    private String basic_addr;
    private String detail_addr;
    private Long shipping_num;
    private Users users;

    public Address toEntity(){
        return Address.builder().basicAddr(basic_addr).detailAddr(detail_addr).shippingNum(shipping_num).users(users).build();
    }
}
