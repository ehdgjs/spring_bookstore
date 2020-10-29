package com.project.bookstore.domain.book;

import com.project.bookstore.domain.cartlist.Cartlist;
import com.project.bookstore.domain.cartlist.MultiId;
import com.project.bookstore.domain.orderlist.Orderlist;
import com.project.bookstore.domain.orderlist.OrderlistMultiid;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Book {

    //책번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_UID")
    private Long uid;

    //책이름
    private String bookName;

    //책수량
    private Long bookCount;

    //책가격
    private Long bookPrice;

    //책세부정보
    private String bookDetail;

    //출판사
    private String bookPublish;

    //작가
    private String bookAuthor;

    @OneToMany(mappedBy = "book")
    private List<Cartlist> cartlists;

    @OneToMany(mappedBy = "book")
    private List<Orderlist> orderlists;

    public Book(Long uid, String bookName, Long bookCount, Long bookPrice, String bookDetail, String bookPublish, String bookAuthor, List<Cartlist> cartlists, List<Orderlist> orderlists){
        this.uid = uid;
        this.bookName = bookName;
        this.bookCount = bookCount;
        this.bookPrice = bookPrice;
        this.bookDetail = bookDetail;
        this.bookPublish = bookPublish;
        this.bookAuthor = bookAuthor;
        this.cartlists = cartlists;
        this.orderlists = orderlists;
    }
}
