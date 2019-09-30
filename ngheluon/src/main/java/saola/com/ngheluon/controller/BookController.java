package saola.com.ngheluon.controller;

import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.ChapterService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController(value = "books")
@RequestMapping("/api/v1/minibooks")
public class BookController extends BaseController<Book> {
  @Autowired
  private BookService service;
  @Autowired
  private ChapterService chapterService;

  @GetMapping("/{bookId}/chapters")
  public List<Chapter> getChapter(@PathVariable String bookId) {
    Book book = service.findById(bookId);
    return chapterService.findByBook(book);
  }

  @GetMapping("/{bookId}/chapters/text")
  public List<String> getChapterContent(@PathVariable String bookId) {
    List<Chapter> chapters = getChapter(bookId);
    List<String> chapterContents = chapters.stream().map(chap -> chap.getContent()).collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/audio/{chapterOrder}")
  public Chapter getChapterAudio(@PathVariable String bookId, @PathVariable Integer chapterOrder) {
    List<Chapter> chapters = getChapter(bookId);
    return chapters.stream().filter(chapter -> chapter.getOrder().equals(chapterOrder)).collect(Collectors.toList()).get(0);
  }
}