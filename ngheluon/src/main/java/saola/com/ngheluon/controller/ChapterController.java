package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.service.ChapterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "chapters")
@RequestMapping("/api/v1/chapters")
public class ChapterController extends BaseController<Chapter> {
  @Autowired
  public ChapterService service;

  @GetMapping("/{bookId}")
  public Page<Chapter> findByBookId(@PathVariable String bookId, Pageable pageable) {
    if (null == bookId || "".equals(bookId.trim())) {
      throw new IllegalArgumentException("Book ID is not valid: " + bookId);
    }

    return service.findByBookId(bookId, pageable);
  }
}