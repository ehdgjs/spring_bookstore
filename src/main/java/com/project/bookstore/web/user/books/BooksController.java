package com.project.bookstore.web.user.books;

import com.project.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BooksController {
    private final BookService bookService;

    @GetMapping("/books/booksave")
    public String booksave(){
        return "books/saveBook";
    }
}
