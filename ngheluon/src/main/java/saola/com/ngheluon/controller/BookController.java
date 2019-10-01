package saola.com.ngheluon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.dto.ChapterContent;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.ChapterService;

@RestController(value = "books")
@RequestMapping("/api/v1/minibooks")
public class BookController extends BaseController<Book> {
  @Autowired
  private BookService service;
  @Autowired
  private ChapterService chapterService;

  @GetMapping("/{bookId}/chapters")
  public List<ChapterContent> getChapter(@PathVariable String bookId) {
    Book book = service.findById(bookId);
    List<Chapter> chapters = chapterService.findByBook(book);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap, false)).collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/text")
  public List<ChapterContent> getChapterContent(@PathVariable String bookId) {
    Book book = service.findById(bookId);
    List<Chapter> chapters = chapterService.findByBook(book);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap)).collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/audio/{chapterOrder}")
  public Chapter getChapterAudio(@PathVariable String bookId, @PathVariable Integer chapterOrder) {
    Book book = service.findById(bookId);
    List<Chapter> chapters = chapterService.findByBook(book);
    return chapters.stream().filter(chapter -> chapter.getOrder().equals(chapterOrder)).collect(Collectors.toList()).get(0);
  }
}