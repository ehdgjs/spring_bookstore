package com.project.bookstore.web.books;

import com.project.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BooksController {
    private final BookService bookService;

    @GetMapping("/books/booksave")
    public String booksave(){
        return "books/saveBook";
    }

    @GetMapping("/books/bookdetail/{uid}")
    public String bookdetail(@PathVariable("uid") Long uid, Model model) {
        model.addAttribute("bookInfo",bookService.findBookById(uid));
        return "books/detailBook";
    }
}
