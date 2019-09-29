package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.service.ChapterService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "chapters")
@RequestMapping("/api/v1/chapters")
public class ChapterController extends BaseController<Chapter> {
  @Autowired
  public ChapterService service;

  @GetMapping("/{bookId}")
  public List<Chapter> findByBookId(@PathVariable String bookId) {
    if (null == bookId || "".equals(bookId.trim())) {
      throw new IllegalArgumentException("Book ID is not valid: " + bookId);
    }
    
    List<Chapter> chapters = new ArrayList<>();
    Book book = new Book();
    chapters = service.findByBook(book);
    return chapters;
  }
}