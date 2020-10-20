package com.project.bookstore.domain.cartlist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
public class Cartlist implements Serializable {

    @EmbeddedId
    private MultiId multiId;

    private Long bookCount;

    @Builder
    public Cartlist(MultiId multiId, Long bookCount){
        this.multiId = multiId;
        this.bookCount = bookCount;
    }
}
