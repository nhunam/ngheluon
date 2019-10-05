package saola.com.ngheluon.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.dto.ChapterContent;
import saola.com.ngheluon.service.ChapterService;

@RestController(value = "books")
@RequestMapping("/api/v1/minibooks")
public class BookController extends BaseController<Book, UUID> {
  @Autowired
  private ChapterService chapterService;

  @GetMapping("/{bookId}/chapters")
  public List<ChapterContent> getChapter(@PathVariable(value = "bookId") String bookId, Pageable pageable) {
	Optional<UUID> bId = validateId(bookId);
    Page<Chapter> chapters = chapterService.findByBookId(bId, pageable);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap, false)).collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/text")
  public List<ChapterContent> getChapterContent(@PathVariable(value = "bookId") String bookId, Pageable pageable) {
	Optional<UUID> bId = validateId(bookId);  
    Page<Chapter> chapters = chapterService.findByBookId(bId, pageable);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap)).collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/audio/{chapterOrder}")
  public Chapter getChapterAudio(@PathVariable(value = "bookId") String bookId, @PathVariable(value = "chapterOrder") Integer chapterOrder) {
    return chapterService.findByBookIdAndOrder(bookId, chapterOrder);
  }

  @Override
  protected Optional<UUID> validateId(String id) {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException e) {
      return Optional.empty();
    }
  }
}