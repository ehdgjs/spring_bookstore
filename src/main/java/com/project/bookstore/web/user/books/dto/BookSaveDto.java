package com.project.bookstore.web.user.books.dto;

import com.project.bookstore.domain.book.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookSaveDto {

    private String bookName;

    private Long bookCount;

    private Long bookPrice;

    private String bookDetail;

    private String bookPublish;

    private String bookAuthor;

    public Book toEntity(){
        return Book.builder().bookName(bookName).bookCount(bookCount).bookPrice(bookPrice).bookDetail(bookDetail).bookPublish(bookPublish).bookAuthor(bookAuthor).build();
    }
}
