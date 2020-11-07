package com.project.bookstore.web.books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.BookService;
import com.project.bookstore.web.books.dto.BookSaveDto;
import com.project.bookstore.web.books.dto.BookUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
        try {
            result = new ApiResponse(true, "성공", bookService.saveBook(bookSaveDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서수정")
    @PostMapping("/updateBooks/{uid}")
    public ResponseEntity<?> updateBooks(@PathVariable("uid") Long uid, @RequestBody BookUpdateDto bookUpdateDto){
        ApiResponse result = null;
        bookUpdateDto.setUid(uid);
        try {
            result = new ApiResponse(true, "성공", bookService.updateBook(bookUpdateDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서삭제")
    @PostMapping("/deleteBooks/{uid}")
    public RedirectView deleteBooks(@PathVariable("uid") Long uid){
        bookService.deleteBook(uid);
        return new RedirectView("/");
    }

}
