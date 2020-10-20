package com.project.bookstore.domain.orderlist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
public class Orderlist implements Serializable {

    @EmbeddedId
    private OrderlistMultiid orderlistMultiid;

    private Long count;

    @Builder
    public Orderlist(OrderlistMultiid orderlistMultiid, Long count){
        this.orderlistMultiid = orderlistMultiid;
        this.count = count;
    }
}
