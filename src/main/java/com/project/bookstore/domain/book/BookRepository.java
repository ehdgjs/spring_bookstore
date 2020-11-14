package com.project.bookstore.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //해당 단어가 책이름, 작가, 출판사에 존재하는 책 리스트
    List<Book> findAllByBookNameIgnoreCaseContainingOrBookAuthorIgnoreCaseContainingOrBookPublishIgnoreCaseContaining(String name, String Author, String Publish);
}
