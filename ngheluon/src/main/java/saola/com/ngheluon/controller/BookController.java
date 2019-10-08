package saola.com.ngheluon.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.dataset.Category;
import saola.com.ngheluon.dataset.Chapter;
import saola.com.ngheluon.dataset.Highlight;
import saola.com.ngheluon.dataset.Topic;
import saola.com.ngheluon.dto.ChapterContent;
import saola.com.ngheluon.dto.ResponseDTO;
import saola.com.ngheluon.service.BookService;
import saola.com.ngheluon.service.CategoryService;
import saola.com.ngheluon.service.ChapterService;
import saola.com.ngheluon.service.HighlightService;
import saola.com.ngheluon.service.TopicService;

@RestController(value = "books")
@RequestMapping("/api/v1/minibooks")
public class BookController extends BaseController<Book, UUID> {
  @Autowired
  private BookService service;
  @Autowired
  private TopicService topicService;
  @Autowired
  private ChapterService chapterService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private HighlightService highlightService;

  @GetMapping("/{bookId}/chapters")
  public List<ChapterContent> getChapter(@PathVariable(value = "bookId") String bookId, Pageable pageable) {
    Optional<UUID> bId = validateId(bookId);
    Page<Chapter> chapters = chapterService.findByBookId(bId, pageable);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap, false))
        .collect(Collectors.toList());
    return chapterContents;
  }

  @GetMapping("/{bookId}/chapters/text")
  public ResponseEntity<ResponseDTO> getChapterContent(@PathVariable(value = "bookId") String bookId,
      Pageable pageable) {
    Optional<UUID> bId = validateId(bookId);
    Page<Chapter> chapters = chapterService.findByBookId(bId, pageable);
    List<ChapterContent> chapterContents = chapters.stream().map(chap -> new ChapterContent(chap))
        .collect(Collectors.toList());
    return ResponseEntity.ok(ResponseDTO.builder().body(chapterContents).build());
  }

  @GetMapping("/{bookId}/chapters/audio/{chapterOrder}")
  public ResponseEntity<ResponseDTO> getChapterAudio(@PathVariable(value = "bookId") String bookId,
      @Valid @PathVariable(value = "chapterOrder") Integer chapterOrder) {
    Optional<UUID> bId = validateId(bookId);
    Chapter chapter = chapterService.findByBookIdAndOrder(bId, chapterOrder);
    return ResponseEntity.ok(ResponseDTO.builder().body(chapter).build());
  }

  @GetMapping("/topics/{topicId}")
  public ResponseEntity<ResponseDTO> getBookByTopic(@PathVariable(value = "topicId") String topicId, Pageable pageable) {
    Optional<UUID> bId = validateId(topicId);
    Topic topic = topicService.findById(bId.get());
    Set<Book> books = topic.getBooks();
    return ResponseEntity.ok(ResponseDTO.builder().body(books).build());
  }

  @GetMapping("/categories/{categoryId}")
  public ResponseEntity<ResponseDTO> getBookByCategory(@PathVariable(value = "categoryId") String categoryId, Pageable pageable) {
    Optional<UUID> bId = validateId(categoryId);
    Category category = categoryService.findById(bId.get());
    Set<Book> books = category.getBooks();
    return ResponseEntity.ok(ResponseDTO.builder().body(books).build());
  }

  @GetMapping("/highlights/{highlightId}")
  public ResponseEntity<ResponseDTO> getBookByHighlight(@PathVariable(value = "highlightId") String highlightId, Pageable pageable) {
    Optional<UUID> bId = validateId(highlightId);
    Highlight highlight = highlightService.findById(bId.get());
    Set<Book> books = highlight.getBooks();
    return ResponseEntity.ok(ResponseDTO.builder().body(books).build());
  }

  @GetMapping("/authors/{authorId}")
  public ResponseEntity<ResponseDTO> getBookByAuthor(@PathVariable(value = "authorId") String authorId, Pageable pageable) {
    Optional<UUID> aId = validateId(authorId);
    Page<Book> books = service.findByAuthorId(aId, pageable);
    return ResponseEntity.ok(ResponseDTO.builder().body(books).build());
  }

  @Override
  protected Optional<UUID> validateId(String id) throws IllegalArgumentException {
    try {
      return Optional.of(UUID.fromString(id));
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException("ID: " + id + " is empty or malformed!");
    }
  }
}