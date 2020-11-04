package com.project.bookstore.service;

import com.project.bookstore.domain.book.BookRepository;
import com.project.bookstore.web.user.books.dto.BookSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public String saveBook(BookSaveDto bookSaveDto){
        return bookRepository.save(bookSaveDto.toEntity()).toString();
    }
}
