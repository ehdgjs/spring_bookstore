package com.project.bookstore.domain.book;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Book {

    //책번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Book(Long uid, String bookName, Long bookCount, Long bookPrice, String bookDetail, String bookPublish, String bookAuthor){
        this.uid = uid;
        this.bookName = bookName;
        this.bookCount = bookCount;
        this.bookPrice = bookPrice;
        this.bookDetail = bookDetail;
        this.bookPublish = bookPublish;
        this.bookAuthor = bookAuthor;
    }
}
