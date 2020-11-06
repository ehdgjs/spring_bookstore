package com.project.bookstore.web.books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.BookService;
import com.project.bookstore.web.books.dto.BookSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "도서", description = "도서 관리", tags = { "도서" })
@RequestMapping("/books")
@RestController
@RequiredArgsConstructor
public class BooksApiController {
    private final BookService bookService;

    @ApiOperation(value = "도서등록")
    @PostMapping("/saveBooks")
    public ResponseEntity<?> saveBooks(@RequestBody BookSaveDto bookSaveDto){
        ApiResponse result = null;
        System.out.println("@@@@@@@@@@@@");
        System.out.println(bookSaveDto.toEntity().getBookName());
        try {
            result = new ApiResponse(true, "성공", bookService.saveBook(bookSaveDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

}
